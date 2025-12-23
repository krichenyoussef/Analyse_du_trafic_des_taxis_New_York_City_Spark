package com.krichenyoussef.nyctaxi

import com.krichenyoussef.nyctaxi.config.AppConfig
import com.krichenyoussef.nyctaxi.jobs.IngestJob
import com.krichenyoussef.nyctaxi.utils.SparkSessionFactory

object Main extends App {
  val config = AppConfig.load()
  val spark = SparkSessionFactory.create(config.appName, Some("local[*]"))

  try {
    val ingest = IngestJob.run(spark, config)
    println(s"Trips rows: ${ingest.trips.count()}")
    println(s"Zones rows: ${ingest.zones.count()}")
  } finally {
    spark.stop()
  }
}
