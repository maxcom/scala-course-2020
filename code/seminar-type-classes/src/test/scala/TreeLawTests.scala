import cats.implicits._
import cats.kernel.laws.discipline.SemigroupTests
import cats.laws.discipline.{FunctorTests, TraverseTests}
import org.specs2._
import org.typelevel.discipline.specs2.Discipline
import TreeArbitrary._

class TreeLawTests extends Specification with Discipline {

  def is = s2"$functorCheck$semigroupCheck$traverseCheck"

  def functorCheck = checkAll("Tree.FunctorLaws", FunctorTests[Tree].functor[Int, Int, String])
  def semigroupCheck = checkAll("Tree[Int].SemigroupLaws", SemigroupTests[Tree[Int]].semigroup)
  def traverseCheck = checkAll("Tree.TraverseLaws", TraverseTests[Tree].traverse[Int, Int, String, Int, Option, Option])
}
