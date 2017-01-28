package pawzzle.library.service.bootstrap

import scala.io.Source

/**
  * Configuration object that loads properties from an service.properties file located in the classpath.
  */
object Configuration {

  private val filename = "service.properties"
  private val map = Source.fromResource(filename).getLines().map(_.split("=")).map(a => a(0) -> a(1)).toMap

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