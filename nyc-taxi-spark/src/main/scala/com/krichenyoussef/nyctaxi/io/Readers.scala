package com.krichenyoussef.nyctaxi.io

import org.apache.spark.sql.{DataFrame, SparkSession}

object Readers {

  def readTripsCsv(spark: SparkSession, path: String): DataFrame =
    if (path.toLowerCase.endsWith(".parquet")) {
      spark.read.parquet(path)
    } else {
      spark.read
        .option("header", "true")
        .option("inferSchema", "true")
        .csv(path)
    }

  def readZonesCsv(spark: SparkSession, path: String): DataFrame =
    spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(path)
}
