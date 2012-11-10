package ie.tcd.sccs.funcprog.josephus

import org.scalatest._

class JosephusSpec extends FlatSpec {
  "Josephus" should "allow you to calculate the solution to Josephus problem" in {
    assert(Josephus.findSurvivor(41, 3-1) === 31)
  }

  it should "also allow you to calculate the solution to this kind of problems in general" in {
    assert(Josephus.findSurvivor(88, 7-1) === 59)
  }

  it should "also be able to calculate the solution with a recursive algorithm" in {
    assert(Josephus.findSurvivorRecursively(41, 3-1) === 31)
    assert(Josephus.findSurvivorRecursively(88, 7-1) === 59)
  }
}
