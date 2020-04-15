package com

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object DivideActor {
  sealed trait Command
  final case class Divide(replyTo: ActorRef[CalculateActor.Result], operand1: Int, operand2: Int) extends Command

  def apply(): Behavior[Command] = Behaviors.receiveMessage {
    case Divide(replyTo, op1, op2) =>
      replyTo ! CalculateActor.Result(op1 / op2)
      Behaviors.same
    case _ =>
      println("unknown command")
      Behaviors.same
  }
}
