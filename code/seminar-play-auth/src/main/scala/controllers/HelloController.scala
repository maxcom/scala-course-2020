package controllers

import javax.inject.Inject
import play.api.mvc._

class HelloController @Inject()(userAction: UserAction, cc: ControllerComponents) extends AbstractController(cc) {
  def index =  Action {
    Ok(s"Please, execute login to start")
  }

  def login(user: String) = Action { request =>
    ???
  }

  def hello() = userAction { request: UserRequest[AnyContent] =>
    Ok(s"Hello, ${request.username}!")
  }

  def logout() = Action {
    Redirect("/").withNewSession
  }
}