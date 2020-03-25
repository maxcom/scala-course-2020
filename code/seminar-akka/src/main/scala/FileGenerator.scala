import java.io.FileWriter
import java.nio.file.{Files, Paths}

object FileGenerator extends App {
  Files.createDirectory(Paths.get("source"))
  Files.createDirectory(Paths.get("dest"))

  (1 to 50).foreach { index =>
    val strIndex = index.toString
    val writer = new FileWriter(s"source/$strIndex")
    writer.write(strIndex * 100)
    writer.close()
  }
}
