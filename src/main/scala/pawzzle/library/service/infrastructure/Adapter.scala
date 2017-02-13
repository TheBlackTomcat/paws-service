package pawzzle.library.service.infrastructure

/**
  * Marker trait for infrastructure adapters as defined by the Ports and Adapters (Hexagonal) architectural style.
  */
trait Adapter

/**
  * Marker trait for data access adapters, specialized type of Adapter.
  */
trait DataAccessAdapter extends Adapter

/**
  * Marker trait for RESTful web services adapters, specialized type of Adapter. RESTful WS adapter should define
  * the API for RESTful WS Style Integrations as defined the the REST architectural style.
  */
trait RESTfulWSAdapter extends Adapter

/**
  * Marker trait for Messaging adapters, specialized type of Adapter. Messaging adapter should define the API for
  * Message Style Integrations as defined by the Enterprise Integration Patterns.
  */
trait MessagingAdapter extends Adapter

/**
  * Marker trait for Notification adapters, specialized type of Adapter. Notification adapter should define the API
  * for platform external notifications like email, sms etc.
  */
trait NotificationAdapter extends Adapter