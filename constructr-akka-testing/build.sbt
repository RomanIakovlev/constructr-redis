name := "constructr-akka-testing"

libraryDependencies ++= Vector(
  Library.constructrAkka       % "test",
  Library.akkaCluster          % "test",
  Library.akkaLog4j            % "test",
  Library.akkaMultiNodeTestkit % "test",
  Library.akkaTestkit          % "test",
  Library.log4jCore            % "test",
  Library.scalaTest            % "test"
)


unmanagedSourceDirectories.in(MultiJvm) := Vector(scalaSource.in(MultiJvm).value)

test.in(Test) := { test.in(MultiJvm).value; test.in(Test).value }

inConfig(MultiJvm)(SbtScalariform.configScalariformSettings)

AutomateHeaderPlugin.automateFor(MultiJvm)
HeaderPlugin.settingsFor(MultiJvm)
