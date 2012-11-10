package ie.tcd.sccs.funcprog.josephus

import scala.util.logging._

object Josephus extends Logged with ConsoleLogger {
// object Josephus extend Logged {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    // val theRing = new RingIterator[Int]()
    // for(i <- 1 to numOfSoldiers) theRing.add(i)
    val soldiers = Range(1, numOfSoldiers+1).toList
    val theRing = new RingIterator[Int](soldiers, 0)

    while(theRing.size > 1) {
      for(i <- 0 until skipping) theRing.advance
      theRing.remove
      log(theRing.dump.mkString(","))
    }

    theRing.get
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
