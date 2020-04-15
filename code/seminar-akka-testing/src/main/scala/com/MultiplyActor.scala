package com

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object MultiplyActor {
  sealed trait Command
  final case class Multiply(replyTo: ActorRef[CalculateActor.Result], operand1: Int, operand2: Int) extends Command

  def apply(): Behavior[Command] = Behaviors.receiveMessage {
    case Multiply(replyTo, op1, op2) =>
      replyTo ! CalculateActor.Result(op1 * op2)
      Behaviors.same
    case _ =>
      println("unknown command")
      Behaviors.same
  }

}
