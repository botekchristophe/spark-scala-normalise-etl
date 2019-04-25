import java.time.LocalDate

import org.scalacheck._
import Gen._
import Arbitrary.arbitrary

type CardNumber = String
def genCardNo: Gen[CardNumber] = Gen.choose(1000, 9999).map(num => "00" + num.toString)
def genLocalDate: Gen[LocalDate] = Gen.choose(0l, 10000l).map(LocalDate.ofEpochDay)

def genLoyaltyCard: Gen[LoyaltyCard] = for {
  card <- genCardNo
  date <- genLocalDate
} yield LoyaltyCard(card, date)

case class LoyaltyCard(cardNo: CardNumber, createdOn: LocalDate)
val a = genLoyaltyCard.sample.get