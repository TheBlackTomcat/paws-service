package pawzzle.library.service.application

/**
  * Base trait for all services. Marks an Application Service as expressed by Domain Driven Design.
  */
trait Service {

  /**
    * Starts a service. :)
    */
  def start(): Unit

  /**
    * Restarts a service. :)
    */
  def restart(): Unit

  /**
    * Shuts down a service. :)
    */
  def shutdown(): Unit
}