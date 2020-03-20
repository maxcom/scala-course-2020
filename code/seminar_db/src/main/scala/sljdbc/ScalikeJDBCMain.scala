package sljdbc

import scalikejdbc.config.DBs
import sljdbc.model.{Department, Person}

/**
 * Ссылка на документацию:
 * http://scalikejdbc.org/documentation/setup.html
 */
object ScalikeJDBCMain extends App {
  /** Сначала нужно загрузить JDBC-драйвер и инициализировать ConnectionPool
   * В данном случае - используется библиотека scalikejdbc-config и конфиг для подключения к БД задается как typesafe config - в application.conf
   * Варианты задания настроек и driver-ов описаны в документации: http://scalikejdbc.org/documentation/configuration.html
   */
  DBs.setupAll()  // Connection pools are prepared

  /**
   * Создаем схему
   */
  DBInit.createDbSchemaPlainSql

  /**
   * Наполняем тестовыми данными: готовый код, так как лучше сосредоточиться на Заданиях ниже
   */
  val departments: Seq[Department] = Seq(
    (Some(1), "Developers"),
    (Some(2), "Testers"),
    (Some(3), "Analytics")).map((Department.apply _).tupled)

  val persons = Seq(
    (None, "Ivan",20,100,1),
    (None, "Dmitriy",35,150,2),
    (None, "Petr",23,125,1),
    (None, "Sergey",24,140,3),
    (None, "Elena",42,130,3),
    (None, "Olga",36,120,3),
    (None, "Viktoria",54,200,1)).map((Person.apply _).tupled)

  DBInit.populateDB(departments, persons)

  /**
   *
   * Задание 1:
   * Реализовать методы сервиса PersonDBService с помощью plain sql запросов
   * Для каждого метода нужно выбрать правильный тип транзакции;
   * Документация: http://scalikejdbc.org/documentation/transaction.html
   *
   * И изучить базовый Query API:
   * http://scalikejdbc.org/documentation/1.x/operations.html
   *
   *
   * Задание 2:
   * Реализовать те же методы, но переписав их с помощью QueryDSL:
   * http://scalikejdbc.org/documentation/query-dsl.html
   *
   * Задание 3(при желании): наполнить даннымим из csv-файлов
   * Реализовать те же методы, но переписав их с помощью QueryDSL:
   * http://scalikejdbc.org/documentation/query-dsl.html
   * Можно посмотреть в сторону вставки-batch-ами
   */

  val service = new PersonDBService
}
