package paws.library.service.infrastructure

/**
  * Marker trait for infrastructure adapters as defined by the Ports and Adapters (Hexagonal) architectural style.
  */
trait Adapter

/**
  * Marker trait for storage adapters, specialized type of Adapter.
  */
trait StorageAdapter extends Adapter

/**
  * Marker trait for integration adapters, specialized type of Adapter.
  */
trait IntegrationAdapter extends Adapter
