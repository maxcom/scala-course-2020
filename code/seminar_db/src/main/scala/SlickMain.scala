/*
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object SlickMain extends App {
  val db = Database.forURL("jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")

  case class Person(id: Option[Int], name: String, age: Int, salary: Int, deptId: Int)
  class PersonTable(tag: Tag) extends Table[Person](tag, "person") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc) // This is the primary key column
    def name = column[String]("name")
    def age = column[Int]("age")
    def salary = column[Int]("salary")
    def deptId = column[Int]("deptId")
    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id.?, name, age, salary, deptId) <> (Person.tupled, Person.unapply)
  }

  case class Department(id: Int, name: String)
  class DepartmentTable(tag: Tag) extends Table[Department](tag, "department") {
    def id = column[Int]("id")
    def name = column[String]("name")

    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id, name) <> (Department.tupled, Department.unapply)
  }

  val persons = TableQuery[PersonTable]
  val department = TableQuery[DepartmentTable]

  val setup = DBIO.seq(
    (persons.schema ++ department.schema).create,
    persons += Person(Some(101), "Example", 10, 20, 123),

  )

  Await.result(db.run(setup), 2 minutes)

  db.close()

}*/
