package ie.tcd.sccs.funcprog.setup

import org.scalatest._

class HelloSpec extends FlatSpec {
  "Hello" should "allow you to increment a value by 1" in {
    assert(Hello.incVal(1) === 2)
  }
}
