package com.krichenyoussef.nyctaxi.utils

import org.apache.spark.sql.SparkSession

object SparkSessionFactory {

  /** Create a SparkSession.
    *
    * @param appName Name shown in Spark UI
    * @param master  Optional master (ex: "local[*]"). If None, Spark uses the default (spark-submit).
    */
  def create(appName: String, master: Option[String] = None): SparkSession = {
    val builder = SparkSession.builder().appName(appName)

    // If you run with sbt run locally, you usually want local[*]
    master.foreach(builder.master)

    val spark = builder
      // Good defaults for dev
      .config("spark.sql.session.timeZone", "UTC")
      .config("spark.sql.shuffle.partitions", "200")
      .getOrCreate()

    // Optional: reduce logs noise
    spark.sparkContext.setLogLevel("WARN")
    spark
  }
}
