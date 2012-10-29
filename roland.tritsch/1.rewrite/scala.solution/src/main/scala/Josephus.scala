package ie.tcd.sccs.funcprog.josephus

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    assert(numOfSoldiers >= 1)
    assert(skipping >= 0)

    // val soldiers = Range(1, numOfSoldiers+1).toList
    // val theRing = new RingIterator[Int](soldiers, soldiers.size-1)
    val theRing = new RingIterator[Int]()
    for(i <- 1 to numOfSoldiers) theRing.add(i)

    theRing.reset(0)
    while(theRing.size > 1) {
      for(i <- 0 until skipping) theRing.advance
      theRing.remove
      // println(theRing.dump.mkString(","))
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
