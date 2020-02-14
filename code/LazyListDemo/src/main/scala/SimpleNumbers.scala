object SimpleNumbers extends App {

  val numbers: LazyList[Int] = 2 +:
    LazyList.from(3)
    .filterNot(v => numbers.takeWhile(_ < v/2+1).exists(v % _ == 0))

  numbers.take(10).foreach(println)
}
