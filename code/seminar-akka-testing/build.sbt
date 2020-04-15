name := "seminar-akka-testing"

version := "0.1"

scalaVersion := "2.13.1"


libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.4"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.4" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test