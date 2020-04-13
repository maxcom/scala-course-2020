import CounterActor.{CommandProtocol, Get, IncrWhen}
import akka.NotUsed
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.AskPattern._
import akka.persistence.query.{EventEnvelope, PersistenceQuery}
import akka.persistence.query.journal.leveldb.scaladsl.LeveldbReadJournal
import akka.persistence.typed.PersistenceId
import akka.persistence.typed.scaladsl.{Effect, EventSourcedBehavior, RetentionCriteria}
import akka.stream.scaladsl.Source
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration._

trait MySerializable

object CounterActor {
  sealed trait CommandProtocol
  case class Get(replyTo: ActorRef[Int]) extends CommandProtocol
  case class IncrWhen(amount: Int, pred: Int => Boolean) extends CommandProtocol

  sealed trait EventProtocol extends MySerializable
  case class Incr(amount: Int) extends EventProtocol

  val commandHandler:
      (Int, CommandProtocol) => Effect[EventProtocol, Int] = {
    (counter, command) =>
      command match {
        case Get(replyTo) =>
          Effect.reply(replyTo)(counter)
        case IncrWhen(amount, pred) =>
          if (pred(counter + amount)) {
            Effect.persist(Incr(amount))
          } else {
            Effect.none
          }
      }
  }

  val eventHandler:
      (Int, EventProtocol) => Int = {
    (state, event) =>
      event match {
        case Incr(amount) => state + amount
      }
  }

  def behavior: Behavior[CommandProtocol] =
    EventSourcedBehavior[CommandProtocol, EventProtocol, Int](
        persistenceId = PersistenceId.ofUniqueId("myCounter"),
        emptyState = 0,
        commandHandler = commandHandler,
        eventHandler = eventHandler)
      .withRetention(RetentionCriteria.snapshotEvery(numberOfEvents = 10, keepNSnapshots = 2)
      .withDeleteEventsOnSnapshot)
}

object ActorDemo extends App {
  implicit val actorSystem: ActorSystem[CommandProtocol] =
    ActorSystem(CounterActor.behavior, "counter")

  // создаем один раз на приложение
  val queries: LeveldbReadJournal =
    PersistenceQuery(actorSystem).readJournalFor[LeveldbReadJournal](LeveldbReadJournal.Identifier)

  val events: Source[EventEnvelope, NotUsed] =
    queries.currentEventsByPersistenceId("myCounter",
      fromSequenceNr = 0)

  events.runForeach(println)

  implicit val timeout: Timeout = 1.minute

  (0 to 20).foreach { _ =>
    actorSystem ! IncrWhen(10, _ => true)
  }

  println(Await.result(actorSystem ? Get, timeout.duration))
}