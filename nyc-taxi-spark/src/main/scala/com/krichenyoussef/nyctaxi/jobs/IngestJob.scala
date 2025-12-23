package com.krichenyoussef.nyctaxi.jobs

import com.krichenyoussef.nyctaxi.config.AppConfig
import com.krichenyoussef.nyctaxi.io.Readers
import org.apache.spark.sql.{DataFrame, SparkSession}

final case class IngestResult(trips: DataFrame, zones: DataFrame)

object IngestJob {
  def run(spark: SparkSession, config: AppConfig): IngestResult = {
    val trips = Readers.readTripsCsv(spark, config.paths.tripsCsv)
    val zones = Readers.readZonesCsv(spark, config.paths.zonesCsv)
    IngestResult(trips, zones)
  }
}
