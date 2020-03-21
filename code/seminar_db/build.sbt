name := "Databases"

version := "0.1"

scalaVersion := "2.12.7"

scalacOptions += "-Ypartial-unification" // 2.11.9+

libraryDependencies ++= Seq(

  // Start with this one
  "org.tpolecat" %% "doobie-core"      % "0.8.8",

  // And add any of these as needed
  "org.tpolecat" %% "doobie-h2"        % "0.8.8",          // H2 driver 1.4.200 + type mappings.
  "org.tpolecat" %% "doobie-hikari"    % "0.8.8",          // HikariCP transactor.
  "org.tpolecat" %% "doobie-specs2"    % "0.8.8" % "test", // Specs2 support for typechecking statements.
  "org.tpolecat" %% "doobie-scalatest" % "0.8.8" % "test",  // ScalaTest support for typechecking statements.

  "com.typesafe.slick" %% "slick" % "3.3.1",
  "org.slf4j" % "slf4j-nop" % "1.7.26",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.1"

)



libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc" % "3.4.1",
  "org.scalikejdbc" %% "scalikejdbc-config"  % "3.4.1",  // Typesafe Config - application.conf
  "com.h2database"  %  "h2"                % "1.4.200",
  "ch.qos.logback"  %  "logback-classic"   % "1.2.3"  // slf4j implementation
)