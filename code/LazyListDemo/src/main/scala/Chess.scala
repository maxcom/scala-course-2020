object Chess extends App {
  val Size = 6
  case class Position(x: Int, y: Int) {
    def possible: Boolean = x>0 && y > 0 && x<=Size && y<=Size
  }

  type Moves = LazyList[Position]

  val start: Position = Position(1, 1)

  def finished(m: Moves) = m.sizeIs == Size * Size

  def nextMoves(current: Moves): LazyList[Moves] = {
    val Position(x, y) = current.head

    val all: LazyList[Position] = LazyList(
      Position(x + 1, y + 2),
      Position(x + 1, y - 2),
      Position(x + 2, y + 1),
      Position(x + 2, y - 1),
      Position(x - 1, y + 2),
      Position(x - 1, y - 2),
      Position(x - 2, y + 1),
      Position(x - 2, y - 1))

    all.filter(_.possible).filterNot(current.contains).map(_ #:: current)
  }

  val allMoves: LazyList[Moves] = LazyList.unfold(LazyList(LazyList(start))) { state =>
    val next = state.flatMap(nextMoves)

    if (next.nonEmpty)
      Some((next.last, next))
    else
      None
  }

  println(allMoves.find(finished))
}
