import scala.util.Random

object Main extends App {

  def genLogs(size: Int, recordLength: Int): Seq[String] = {
    val levels = Map(0 -> "INFO", 1 -> "WARN", 2 -> "ERROR")
    (1 to size).map { _ =>
      s"${levels(Random.nextInt(3))}:${Random.alphanumeric.take(recordLength).mkString("")}"
    }
  }

}
