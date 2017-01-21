package pawzzle.library.service.domain

import java.util.UUID

/**
  * Marker trait for the Repository pattern as expressed by Domain Driven Design.
  */
trait Repository {

  /**
    * Generates a unique random EntityID based on the Java UUID random generator.
    * @return Unique EntityID.
    */
  def uniqueId(): EntityID = EntityID(UUID.randomUUID().toString.toUpperCase)
}