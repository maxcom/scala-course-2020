name := "play-authentication"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += guice

enablePlugins(PlayScala)
disablePlugins(PlayLayoutPlugin)

PlayKeys.playMonitoredFiles ++=
  (sourceDirectories in
    (Compile, TwirlKeys.compileTemplates)).value