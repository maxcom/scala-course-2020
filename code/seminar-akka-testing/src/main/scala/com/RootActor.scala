package com

import akka.actor.typed.scaladsl.Behaviors


object RootActor {
  def apply() = Behaviors.setup { ctx =>
    val sum = ctx.spawn(SumActor(), "sum-actor")
    val multiply = ctx.spawn(MultiplyActor(), "multiply-actor")
    val divide = ctx.spawn(DivideActor(), "divide-actor")

    ctx.spawn(CalculateActor(sum, multiply, divide), "calculate-actor")

    Behaviors.empty
  }
}
