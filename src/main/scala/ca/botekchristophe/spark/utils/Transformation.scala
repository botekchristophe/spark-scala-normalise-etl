package ca.botekchristophe.spark.utils

import julienrf.json.derived._
import play.api.libs.json._

sealed trait Transformation

case class Cast(field: String, newType: String) extends Transformation

case class Rename(existing: String, to: String) extends Transformation

object Transformation {
  implicit lazy val format: OFormat[Transformation] = flat.oformat((__ \ "type").format[String])
}