package pawzzle.library.service.bootstrap

import java.io.IOException

import scala.io.Source

/**
  * Configuration object that loads properties from an service properties file located in the classpath.
  */
class Configuration {

  import Configuration._

  /**
    * Gets a string property.
    *
    * @param name The property name.
    * @return The property value.
    */
  def getProp(name: String): String = map(name)

  /**
    * Gets an integer property.
    *
    * @param name The property name.
    * @return The property value.
    */
  def getPropAsInt(name: String): Int = map(name).toInt
}

object Configuration {

  private val filename = "service.properties"
  private var map: Map[String, String] = load(filename)

  def apply(): Configuration = new Configuration()

  private[bootstrap] def apply(filename: String): Configuration = {
    map = load(filename)
    new Configuration()
  }

  private def load(filename: String = filename): Map[String, String] = {
    try {
      Source.fromResource(filename).getLines().map(_.split("=")).map(a => a(0).trim -> a(1)).toMap
    } catch {
      case _: Throwable => throw new IOException("Properties file missing or could not be loaded.")
    }
  }
}