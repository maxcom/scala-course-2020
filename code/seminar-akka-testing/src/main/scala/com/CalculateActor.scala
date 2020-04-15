package com

import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.AskPattern._
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object CalculateActor {
  sealed trait Command
  final case class Calculate(operation: String, operand1: Int, operand2: Int, replyTo: ActorRef[Result]) extends Command
  final case class Result(result: Int) extends Command

  def apply(sum: ActorRef[SumActor.Command],
            multiply: ActorRef[MultiplyActor.Command],
            divide: ActorRef[DivideActor.Command]): Behavior[Command] = Behaviors.setup[Command] { ctx =>
    implicit val timeout: Timeout = 10.seconds
    implicit val ex: ExecutionContext = ctx.executionContext
    implicit val sys: ActorSystem[Nothing] = ctx.system

    Behaviors.receiveMessage[Command] {
      case Calculate(operation, op1, op2, replyTo) =>
        val result = operation match {
          case "sum" => sum.ask(ref => SumActor.Sum(ref, op1, op2))
          case "multiply" => multiply.ask(ref => MultiplyActor.Multiply(ref, op1, op2))
          case "divide" => divide.ask(ref => DivideActor.Divide(ref, op1, op2))
        }

        result.onComplete {
          case Success(res) => replyTo ! res
          case Failure(e) =>
            ctx.log.info("Command execution failed")
            replyTo ! Result(-1)
        }

        Behaviors.same
      case _ =>
        ctx.log.info("Unknown command")
        Behaviors.same
    }
  }
}
