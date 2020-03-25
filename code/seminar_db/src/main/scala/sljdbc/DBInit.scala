package sljdbc

import scalikejdbc._
import sljdbc.model.{Department, Person}

object DBInit {
  def createDbSchemaPlainSql(implicit session: DBSession = AutoSession) = {
    sql"""
          $createDepartmentTableSQL
          $createPersonTableSQL
       """.execute.apply()
  }

  val createDepartmentTableSQL: SQLSyntax = sqls"""CREATE TABLE department (
                                           |            id INT,
                                           |            name VARCHAR NOT NULL UNIQUE
                                           |          );""".stripMargin

  val createPersonTableSQL : SQLSyntax = sqls"""CREATE TABLE person (
                                         |  id   SERIAL,
                                         |  name VARCHAR NOT NULL UNIQUE,
                                         |  age  SMALLINT,
                                         |  salary INT,
                                         |  deptId INT
                                         |);""".stripMargin

  def populateDB(departments: Seq[Department], persons: Seq[Person]): Unit = {
    implicit val session = AutoSession

    departments foreach { case dep =>
      import dep._
      sql"insert into department (id, name) values (${id}, ${name})".update.apply()
    }

    persons foreach { person =>
      import person._
      sql"insert into person (name, age, salary, deptId) values (${name}, ${age}, ${salary}, ${deptId})".update.apply()
    }
  }
}
