/* Paul Martin 09613986 */

package ie.tcd.sccs.funcprog.josephus


import java.util.{List => MyList}
import java.util.LinkedList
import org.apache.commons.collections.iterators.LoopingListIterator


object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
      require(numOfSoldiers >= 1)
      require(skipping >= 0)

      var ring = new LinkedList[Int]()
      // populate listBuffer
      for(i <- 1 to numOfSoldiers) ring.add(i)
      // create the iterator
      val theRing = new LoopingListIterator(ring)
      while(theRing.size > 1){
	 for (i <- 1 to skipping + 1) theRing.next
	 theRing.remove
      }
      theRing.reset // reset
      theRing.next.asInstanceOf[Int] // return result
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt
    println("Result: " + findSurvivor(numOfSoldiers, killingEvery-1))
  }
}