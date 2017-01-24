package pawzzle.library.service.bootstrap

import pawzzle.library.service.application.Service

/**
  * Bootstraps a service based on the configuration file service.conf and the type provided when calling the specific
  * boot method.
  */
trait ServiceBootstrap {

  /**
    * Boots a service by instantiating a concrete service class as defined in the configuration using the property
    * "service.class" and returning an instance of the service trait of type S.
    * @tparam S The trait type representing the service contract.
    * @return An instance of the concrete class representing the service implementation.
    */
  def boot[S <: Service](): S
}

object ServiceBootstrap {

  def apply(c: Configuration): ServiceBootstrap = new ServiceBootstrap() {

    override def boot[S <: Service](): S = Class.forName(c.getProp("service.class")).newInstance().asInstanceOf[S]
  }
}