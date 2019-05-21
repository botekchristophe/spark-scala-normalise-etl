package ca.botekchristophe.spark.utils.theodolite

import org.apache.spark.sql.DataFrame

object ProfilingOps {

  implicit class ProfilingOperations(df: DataFrame) {
    def isPrimaryKey(colname: String): Boolean = {
      df.count() == df.select(colname).distinct().count()
    }
  }
}
