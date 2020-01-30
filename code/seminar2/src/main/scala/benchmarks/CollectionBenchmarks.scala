package benchmarks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

import scala.util.Random

// sbt
// jmh:run -f 1 -i 1
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.Throughput))
class CollectionBenchmarks {
  @Benchmark
  def listAppend(scope: BenchmarkState) = scope.randomList :+ 1

  @Benchmark
  def listPrepend(scope: BenchmarkState) = 1 +: scope.randomList
}

@State(Scope.Benchmark)
class BenchmarkState {
  val randomList: List[Int] = List.fill(10000)(Random.nextInt())
}