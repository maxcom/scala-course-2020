name := "Tree"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.0.0",
  "org.typelevel" %% "discipline-specs2" % "1.0.0",
  "org.specs2" %% "specs2-core" % "4.8.3" % Test,
  "org.typelevel" %% "cats-laws" % "2.0.0" % Test,
  "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % "1.2.3" % Test
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")