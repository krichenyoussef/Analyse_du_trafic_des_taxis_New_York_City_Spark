package com.krichenyoussef.nyctaxi.config

import com.typesafe.config.{Config, ConfigFactory}

final case class Paths(
  tripsCsv: String,
  zonesCsv: String,
  outClean: String,
  outEnriched: String,
  outAnalytics: String
)

final case class AppConfig(appName: String, paths: Paths)

object AppConfig {
  def load(): AppConfig = {
    val c: Config = ConfigFactory.load()

    AppConfig(
      appName = c.getString("app.name"),
      paths = Paths(
        tripsCsv     = c.getString("paths.tripsCsv"),
        zonesCsv     = c.getString("paths.zonesCsv"),
        outClean     = c.getString("paths.outClean"),
        outEnriched  = c.getString("paths.outEnriched"),
        outAnalytics = c.getString("paths.outAnalytics")
      )
    )
  }
}
