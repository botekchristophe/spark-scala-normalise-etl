
name := "spark-scala-normalise-etl"

version := (version in ThisBuild).value

organization := "ca.botekchristophe"

scalaVersion := "2.12.8"

scalacOptions ++= Seq("-deprecation")

val sparkVersion = "2.4.3"
val junitVersion = "4.10"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "org.apache.spark"           %% "spark-core"               % sparkVersion,
  "org.apache.spark"           %% "spark-sql"                % sparkVersion,
  "org.apache.spark"           %% "spark-hive"               % sparkVersion,
  //"com.fasterxml.jackson.core" %  "jackson-core"             % "2.9.8",
  "org.scalatest"              %% "scalatest"                % "3.0.5"       % Test,
  "org.scalacheck"             %% "scalacheck"               % "1.14.0",
  //"org.julienrf"               %% "play-json-derived-codecs" % "5.0.0"
)

cleanFiles += baseDirectory.value / "derby.log"
cleanFiles += baseDirectory.value / "spark-warehouse"
cleanFiles += baseDirectory.value / "metastore_db"
