package ca.botekchristophe.spark.utils.theodolite.example

import ca.botekchristophe.spark.utils.theodolite.FileTypes.CSV
import ca.botekchristophe.spark.utils.theodolite.TheodoliteJob

object HeartProfiling extends TheodoliteJob {
  override val filePath = "heart.csv"
  override val fileType = CSV

  profile()
}
