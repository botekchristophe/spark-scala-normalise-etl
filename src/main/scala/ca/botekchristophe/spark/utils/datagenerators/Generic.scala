package ca.botekchristophe.spark.utils.datagenerators

import java.time.LocalDate

import org.scalacheck.Gen
import org.scalacheck.Gen.numChar

object Generic {
  type FormatedNumber = String

  /**
    * generates a 4 digit random number as a String
    * @return
    */
  def genFormatedNumber: Gen[FormatedNumber] = Gen.choose(1000, 9999).map(_.toString)

  def genFormatedNumber(size: Int): Gen[FormatedNumber] = Gen.listOfN(size, numChar).map(_.mkString)

  //def genFormatedNumber(size: Int, prefix: String): Gen[FormatedNumber] = Gen.listOfN(size, numChar).map(_.mkString)

  def genFormatedNumber(size: Int, format: String): Gen[FormatedNumber] = Gen.listOfN(size, numChar).map(r => format.format(r.toString.toInt))

  def genLocalDate: Gen[LocalDate] = Gen.choose(0l, 10000l).map(LocalDate.ofEpochDay)
}
