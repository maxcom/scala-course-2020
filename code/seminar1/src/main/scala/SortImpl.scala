object SortImpl {
  def sort(input: Vector[Int]): Vector[Int] = input.sorted

  // broken implementations that violates some rules
  def brokenSort(input: Vector[Int]): Vector[Int] = sort(input).distinct

  def brokenSort2(input: Vector[Int]): Vector[Int] = sort(input).map(_ + 1)
}
