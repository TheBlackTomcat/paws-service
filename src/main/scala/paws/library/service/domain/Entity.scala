package paws.library.service.domain

/**
  * Marker trait for the Entity pattern as expressed by Domain Driven Design. Contains an id of type EntityID.
  */
trait Entity {
  def id: EntityID
}

/**
  * EntityID ValueObject used as an unique id for entities.
  * @param id The id of the Entity. Required.
  */
case class EntityID(id: String) {
  require(id != null && !id.isEmpty)
}