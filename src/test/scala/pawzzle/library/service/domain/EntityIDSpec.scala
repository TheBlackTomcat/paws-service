package pawzzle.library.service.domain

import org.scalatest.FlatSpec

/**
  * Specification test for EntityID class.
  */
class EntityIDSpec extends FlatSpec {

  "An EntityID" should "accept an id" in {
    EntityID("id")
  }

  it should "produce IllegalArgumentException when null is passed as an id" in {
    assertThrows[IllegalArgumentException](EntityID(null))
  }

  it should "produce IllegalArgumentException when empty string is passed as an id" in {
    assertThrows[IllegalArgumentException](EntityID(""))
  }
}
