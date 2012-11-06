package ie.tcd.sccs.funcprog.josephus

import org.scalatest._

class JosephusSpec extends FlatSpec {
  "Josephus" should "allow you to calculate the solution to Josephus problem" in {
    assert(Josephus.findSurvivor(41, 3) === 31)
  }
}
