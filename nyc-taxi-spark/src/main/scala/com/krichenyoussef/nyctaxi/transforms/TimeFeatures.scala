package com.krichenyoussef.nyctaxi.transforms

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object TimeFeatures {

  /** Supports both "tpep_*" (yellow) and "lpep_*" (green) columns */
  def withTime(df: DataFrame): DataFrame = {
    val cols = df.columns.toSet

    val pickupCol  =
      if (cols.contains("tpep_pickup_datetime")) "tpep_pickup_datetime"
      else if (cols.contains("lpep_pickup_datetime")) "lpep_pickup_datetime"
      else "pickup_datetime"

    val dropoffCol =
      if (cols.contains("tpep_dropoff_datetime")) "tpep_dropoff_datetime"
      else if (cols.contains("lpep_dropoff_datetime")) "lpep_dropoff_datetime"
      else "dropoff_datetime"

    df
      .withColumn("pickup_ts",  to_timestamp(col(pickupCol)))
      .withColumn("dropoff_ts", to_timestamp(col(dropoffCol)))
      .withColumn("trip_duration_min",
        (unix_timestamp(col("dropoff_ts")) - unix_timestamp(col("pickup_ts"))) / 60.0
      )
      .withColumn("hour", hour(col("pickup_ts")))
      .withColumn("day_of_week", date_format(col("pickup_ts"), "E"))
  }
}
