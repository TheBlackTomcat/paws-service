package pawzzle.library.service.bootstrap

import java.io.IOException

import org.scalatest.FlatSpec

/**
  * Specification test for Configuration object.
  */
class ConfigurationSpec extends FlatSpec {

  "Configuration" should "successfully load the configuration file" in {
    Configuration()
  }

  it should "fail with IOException when the service.properties file does not exist in classpath" in {
    assertThrows[IOException] {
      Configuration("")
    }
  }

  it should "fail with IOException when the invalid.properties file is not properly formatted" in {
    assertThrows[IOException] {
      Configuration("invalid.properties")
    }
  }

  "Configuration().getProp()" should "return a String value of a valid String property" in {
    val prop01: String = Configuration().getProp("prop01")
    assert(prop01 == "value")
  }

  it should "return the property value when the property name contains leading or trailing spaces " +
    "(should trim the name)" in {
    val prop03: String = Configuration().getProp("prop03")
    assert(prop03 == "value")
  }

  it should "return the property value containing leading or trailing spaces " +
    "(should not trim the value)" in {
    val prop04: String = Configuration().getProp("prop04")
    assert(prop04 == " value ")
  }

  it should "fail with NoSuchElementException when a requested property does not exist" in {
    assertThrows[NoSuchElementException] {
      Configuration().getProp("noprop")
    }
  }

  "Configuration().getPropAsInt()" should "return an Int value of a valid Int property" in {
    val prop02: Int = Configuration().getPropAsInt("prop02")
    assert(prop02 == 100)
  }

  it should "fail with NumberFormatException when a property cannot be converted to Int" in {
    assertThrows[NumberFormatException] {
      Configuration().getPropAsInt("prop01")
    }
  }

  it should "fail with NumberFormatException when a property value contains leading or trailing spaces " +
    "(should not trim the value)" in {
    assertThrows[NumberFormatException] {
      Configuration().getPropAsInt("prop06")
    }
  }

  it should "fail with NoSuchElementException when a requested property does not exist" in {
    assertThrows[NoSuchElementException] {
      Configuration().getPropAsInt("noprop")
    }
  }

  it should "return the property value when the property name contains leading or trailing spaces " +
    "(should trim the name)" in {
    val prop05: Int = Configuration().getPropAsInt("prop05")
    assert(prop05 == 100)
  }
}