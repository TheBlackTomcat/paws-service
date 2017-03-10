lazy val `pawzzle-service-library` = (project in file("."))
  .settings(
    name := "pawzzle-service-library",
    version := "0.1.0-SNAPSHOT",
    organization := "com.theblacktomcat.pawzzle",
    scalaVersion := "2.12.1",
    coverageEnabled := true,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
