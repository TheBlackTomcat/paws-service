package pawzzle.library.service.bootstrap

import org.scalatest.FlatSpec
import pawzzle.library.service.application.Service

/**
  * Specification test for ServiceBootstrap object.
  */
class ServiceBootstrapSpec extends FlatSpec {

  "ServiceBootstrap.boot[S <: Service]()" should "create and return a new TheTestService instance as TestService" in {
    val service: TestService = ServiceBootstrap.boot[TestService]()
    assert(service.isInstanceOf[TheTestService])
  }

  it should "fail with ClassNotFoundException if the provided service.class property value is " +
    "a class that cannot be found" in {
    assertThrows[ClassNotFoundException] {
      ServiceBootstrap.boot[TestService]("service.class.nonexistent")
    }
  }

  it should "fail with ClassCastException if the provided service.class property value is " +
    "a class that does not extend the application.Service trait" in {
    assertThrows[ClassCastException] {
      ServiceBootstrap.boot[TestService]("service.class.invalid")
    }
  }
}

trait TestService extends Service

class TheTestService extends TestService {
  override def start(): Unit = {}
  override def restart(): Unit = {}
  override def shutdown(): Unit = {}
}

class NotAServiceImplementationClass
