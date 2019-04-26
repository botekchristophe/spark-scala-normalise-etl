import java.time.LocalDate

import org.scalacheck._
import Gen._
import Arbitrary.arbitrary

type CardNumber = String
def genCardNo: Gen[CardNumber] = Gen.numStr.map(_.take(10))
def genLocalDate: Gen[LocalDate] = Gen.choose(0l, 10000l).map(LocalDate.ofEpochDay)

case class LoyaltyCard(cardNo: CardNumber, createdOn: LocalDate)

def genLoyaltyCard: Gen[LoyaltyCard] = for {
  card <- genCardNo
  date <- genLocalDate
} yield LoyaltyCard(card, date)

val a = genLoyaltyCard.sample.get


case class DatePair(valid_from: LocalDate, valid_to: LocalDate)

def genValidDatePair: Gen[DatePair] = for {
  from <- genLocalDate
  to <- genLocalDate.retryUntil(_.isAfter(from))
} yield DatePair(from, to)

genValidDatePair.sample.get

"%07c".format("hhh")