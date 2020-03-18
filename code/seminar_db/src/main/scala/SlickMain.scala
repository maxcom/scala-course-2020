import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global

object SlickMain extends App {
  val db = Database.forConfig("h2slick")

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
    // Create the tables, including primary and foreign keys
    (persons.schema ++ department.schema).create,

    // Insert some suppliers
    persons += Person(Some(101), "Acme, Inc.",      "99 Market Street", "Groundsville", "CA", "95199"),

    // Equivalent SQL code:
    // insert into SUPPLIERS(SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP) values (?,?,?,?,?,?)

    // Insert some coffees (using JDBC's batch insert feature, if supported by the DB)
    coffees ++= Seq(
      ("Colombian",         101, 7.99, 0, 0),
      ("French_Roast",       49, 8.99, 0, 0),
      ("Espresso",          150, 9.99, 0, 0),
      ("Colombian_Decaf",   101, 8.99, 0, 0),
      ("French_Roast_Decaf", 49, 9.99, 0, 0)
    )
    // Equivalent SQL code:
    // insert into COFFEES(COF_NAME, SUP_ID, PRICE, SALES, TOTAL) values (?,?,?,?,?)
  )

  db.close()

}
