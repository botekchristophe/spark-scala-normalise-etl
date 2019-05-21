package ca.botekchristophe.spark.utils.theodolite

object FileTypes {
  sealed trait FileType
  case object CSV extends FileType
  case object PARQUET extends FileType
  case object ORC extends FileType
  case object AVRO extends FileType
}
