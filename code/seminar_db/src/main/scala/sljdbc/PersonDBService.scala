package sljdbc

import scalikejdbc.{AutoSession, DBSession}
import sljdbc.model.Person

class PersonDBService {
  def findById(id: Long)(implicit session: DBSession = AutoSession): Person = ???

  /**
   * используем JOIN
   */
  def findPersonsByDepartmentId(id: Long): List[Person] = ???

  def updatePersonById(id: Long): Person = ???

  /**
   * Метод должен возвращать Id созданного объекта
   * Полезно будет почитать про AutoSession: http://scalikejdbc.org/documentation/auto-session.html
   */
  def insertNewPerson(person: Person): Int = ???
}