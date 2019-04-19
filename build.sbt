
name := "spark-scala-normalise-etl"

version := (version in ThisBuild).value

organization := "ca.botekchristophe"

scalaVersion := "2.12.8"

scalacOptions ++= Seq("-deprecation")

val sparkVersion = "2.4.1"
val junitVersion = "4.10"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"  % sparkVersion,
  "org.apache.spark" %% "spark-sql"   % sparkVersion,
  "org.apache.spark" %% "spark-hive"  % sparkVersion,
  "junit"            % "junit"        % junitVersion  % Test
)

cleanFiles += baseDirectory.value / "derby.log"
cleanFiles += baseDirectory.value / "spark-warehouse"
cleanFiles += baseDirectory.value / "metastore_db"
