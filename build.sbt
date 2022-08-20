ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"
ThisBuild / organization := "com.gmail.rotoyutoriapp"

mainClass := Some("com.gmail.rotoyutoriapp.ScalaTraining")

assemblyJarName := {
  s"${name.value}-${version.value}.jar"
}

lazy val root = (project in file("."))
  .settings(
    name := "ScalaTraining"
  )

assembly / assemblyMergeStrategy := {
  case PathList("javax", "servlet", _*) => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".properties" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".types" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".class" => MergeStrategy.first
  case "application.conf" => MergeStrategy.concat
  case "unwanted.txt" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}
