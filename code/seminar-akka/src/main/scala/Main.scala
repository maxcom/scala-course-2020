import java.nio.file.{Files, Path, Paths}
import scala.jdk.CollectionConverters._

object Main extends App {
  def groupFiles(files: List[Path], groupSize: Int): List[List[Path]] = files.grouped(groupSize).toList

  val filesToMove = Files.list(Paths.get("source")).iterator().asScala.toList
}
