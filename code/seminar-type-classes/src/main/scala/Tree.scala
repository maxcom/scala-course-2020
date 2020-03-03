import cats.{Applicative, Eq, Eval, Functor, Semigroup, Traverse}

sealed abstract class Tree[+A]

object Tree {
  final case object Empty extends Tree[Nothing]
  final case class Branch[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

  implicit def eqTree[A: Eq]: Eq[Tree[A]] = Eq.fromUniversalEquals

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = ???
  }

  implicit def treeSemigroup[A: Semigroup]: Semigroup[Tree[A]] = new Semigroup[Tree[A]] {
    def combine(x: Tree[A], y: Tree[A]): Tree[A] = ???
  }

  implicit val treeTraverse: Traverse[Tree] = new Traverse[Tree] {
    override def traverse[F[_], A, B](fa: Tree[A])(f: A => F[B])(implicit ev: Applicative[F]): F[Tree[B]] = ???

    override def foldLeft[A, B](fa: Tree[A], b: B)(f: (B, A) => B): B = ???

    override def foldRight[A, B](fa: Tree[A], lb: Eval[B])(f: (A, Eval[B]) => Eval[B]): Eval[B] = ???
  }
}