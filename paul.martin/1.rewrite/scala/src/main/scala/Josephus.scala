/* Paul Martin 09613986 */

package ie.tcd.sccs.funcprog.josephus


import scala.collection.mutable.ListBuffer


object Josephus {

    def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
	var ring = new ListBuffer[Int]()
	// populate listBuffer
	for(i <- 1 to numOfSoldiers) ring += i
	// create the iterator
	val theRing = new RingIterator[Int](ring.toList, 0)
	
	for (i <- numOfSoldiers until 1 by -1) {
	    for (i <- 0 until skipping) theRing.advance
	    theRing.remove
	}
	theRing.reset(0)
	theRing.get // return whats left
    }

    /* Invokes the findSurvivor solution on the 1st and 2nd parameter */
    def main(args: Array[String]): Unit = {
        println("Result: " + findSurvivor(Integer.parseInt(args(0)), Integer.parseInt(args(1))))
    }
}