ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "nyc-taxi-spark",
    version := "0.1.0",
    organization := "com.tonnom",

    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "3.5.1",
      "com.typesafe" % "config" % "1.4.3"
    )
  )
