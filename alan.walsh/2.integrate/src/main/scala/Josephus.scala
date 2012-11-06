package ie.tcd.sccs.funcprog.josephus

import java.util._
import org.apache.commons.collections.iterators.LoopingListIterator
// TODO import Java classes

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)
    
	val army = new java.util.LinkedList[Int]
	for(i <- 1 to numOfSoldiers)  army.add(i)
	val iter = new LoopingListIterator(army)

    while (iter.size > 1){
		for(i <- 0 until skipping+1) iter.next
	    iter.remove
	}
	//army.getFirst
	iter.next.asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
