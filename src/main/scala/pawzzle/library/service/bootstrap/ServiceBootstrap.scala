package pawzzle.library.service.bootstrap

import pawzzle.library.service.application.Service

/**
  * Bootstraps a service based on the configuration file and the type provided when calling the boot method.
  */
object ServiceBootstrap {

  /**
    * Boots a service by instantiating a concrete service class as defined in the configuration using the property
    * "service.class" and returning an instance of the service trait of type S.
    *
    * @param serviceClassProp The optional property name for the concrete fully qualified service class name to be
    *                         instantiated. If not provided it defaults to "service.class".
    * @tparam S The trait or abstract class type representing the service contract.
    * @return An instance of the concrete class representing the service implementation.
    */
  def boot[S <: Service](serviceClassProp: String = "service.class"): S =
    Class.forName(Configuration().getProp(serviceClassProp)).newInstance().asInstanceOf[S]
}