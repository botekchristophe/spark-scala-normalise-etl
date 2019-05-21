package ca.botekchristophe.spark.utils

import org.apache.spark.sql.SparkSession

trait SparkJob extends App {

  val spark = SparkSession
    .builder()
    .appName("Spark Job")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

}
