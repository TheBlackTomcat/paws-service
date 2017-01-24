package pawzzle.library.service.bootstrap

import scala.io.Source

/**
  * Configuration object that loads properties from an service.properties file located in the classpath.
  */
class Configuration {

  private var cMap = Map.empty[String, String]

  def getProp(name: String): String = cMap(name)

  def getPropAsInt(name: String): Int = cMap(name).toInt
}

object Configuration {

  def apply(): Configuration = {

    val filename: String = "service.properties"
    val config = new Configuration()

    config.cMap = Source.fromResource(filename).getLines().map(_.split("=")).map(a => a(0) -> a(1)).toMap
    config
  }
}