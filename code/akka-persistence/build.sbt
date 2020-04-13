name := "temp"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.4"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-serialization-jackson" % "2.6.4"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-persistence-query" % "2.6.4"

libraryDependencies +=
  "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"

libraryDependencies += // или другой backend Slf4j
  "ch.qos.logback" % "logback-classic" % "1.2.3"
