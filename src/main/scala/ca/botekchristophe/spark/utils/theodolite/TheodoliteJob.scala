package ca.botekchristophe.spark.utils.theodolite

import ca.botekchristophe.spark.utils.SparkJob
import ca.botekchristophe.spark.utils.theodolite.FileTypes.{CSV, FileType}
import ca.botekchristophe.spark.utils.theodolite.ProfilingOps._
import org.apache.spark.sql.DataFrame

trait TheodoliteJob extends SparkJob {

  val filePath: String
  val fileType: FileType

  //read file
  def rawDf: DataFrame = fileType match {
    case CSV => spark.read.option("header", "true").option("delimiter", ",").csv(s"src/main/resources/raw/$filePath")
  }

  //analyse file
  def profile(): Unit = {
    val columns = rawDf.columns
    columns.foreach(col =>
      println(rawDf.isPrimaryKey(col))
    )
  }

}
