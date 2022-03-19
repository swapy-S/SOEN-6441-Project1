name := """Project-part1"""
organization := "concordia"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  guice,
  ws,
  // Java11 requires mockito 4.0.0
  "org.mockito" % "mockito-core" % "4.0.0" % "test",
  caffeine,
"com.google.code.gson" % "gson" % "2.2.4"

)

