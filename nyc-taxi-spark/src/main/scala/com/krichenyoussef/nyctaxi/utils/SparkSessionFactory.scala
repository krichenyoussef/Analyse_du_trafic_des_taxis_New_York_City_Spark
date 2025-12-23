package com.tonnom.nyctaxi.utils

import org.apache.spark.sql.SparkSession

object SparkSessionFactory {
  def create(appName: String, master: Option[String] = Some("local[*]")): SparkSession = {
    val b = SparkSession.builder().appName(appName)
    master.foreach(b.master)

    val spark = b
      .config("spark.sql.session.timeZone", "UTC")
      .getOrCreate()

    spark.sparkContext.setLogLevel("WARN")
    spark
  }
}
