package ca.botekchristophe.spark.utils

case class NormalizeJobConfig(source: RawData,
                              target: NormaliseData,
                              transformations: List[Transformation])

case class RawData(path: String,
                   format: Option[String] = None)

case class NormaliseData(databaseName: String,
                         tableName: String,
                         sqlLocation: String)