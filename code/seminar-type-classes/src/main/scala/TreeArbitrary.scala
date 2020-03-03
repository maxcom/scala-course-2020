import Tree.{Branch, Empty}
import org.scalacheck.{Arbitrary, Gen}

object TreeArbitrary {
  implicit def arbTree[A: Arbitrary]: Arbitrary[Tree[A]] = {
    val empty = Gen.const(Empty)
    val simple =
      for {
        e <- Arbitrary.arbitrary[A]
      } yield Branch(e, Empty, Empty)
    val leftBranch =
      for {
        root <- Arbitrary.arbitrary[A]
        left <- Arbitrary.arbitrary[A]
      } yield Branch(root, Branch(left, Empty, Empty), Empty)
    val full =
      for {
        root <- Arbitrary.arbitrary[A]
        left <- Arbitrary.arbitrary[A]
        right <- Arbitrary.arbitrary[A]
      } yield Branch(root, Branch(left, Empty, Empty), Branch(right, Empty, Empty))

    Arbitrary(Gen.oneOf(empty, simple, leftBranch, full))
  }
}
