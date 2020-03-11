package controllers

import javax.inject.Inject
import play.api.mvc.{ActionBuilder, AnyContent, BodyParsers, Request, Result, Results, WrappedRequest}

import scala.concurrent.{ExecutionContext, Future}

class UserRequest[A](val username: String, request: Request[A]) extends WrappedRequest[A](request)

class UserAction @Inject() (val parser: BodyParsers.Default)(implicit val executionContext: ExecutionContext)
  extends ActionBuilder[UserRequest, AnyContent] {
  override def invokeBlock[A](request: Request[A], block: UserRequest[A] => Future[Result]): Future[Result] = {
    ???
  }
}
