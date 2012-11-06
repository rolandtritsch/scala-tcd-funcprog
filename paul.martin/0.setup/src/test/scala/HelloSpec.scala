package ie.tcd.sccs.funcprog.setup


class HelloSpec extends FlatSpec {
  "Hello" should "allow you to increment a value by 1" in {
    assert(Hello.incVal(1) === 2)
  }
}
