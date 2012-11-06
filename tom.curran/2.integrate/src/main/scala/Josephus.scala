package ie.tcd.sccs.funcprog.josephus

import java.util.LinkedList
import java.util.Iterator

import org.apache.commons.collections.iterators.LoopingListIterator

import scala.util.logging.{Logged, ConsoleLogger}

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)
    
    val theRing: java.util.LinkedList[Int] = new LinkedList()
    for(i <- 1 to numOfSoldiers) theRing.add(i)
    
    val itr = new LoopingListIterator(theRing)
    
    while(itr.size > 1){
        for(i <- 1 to skipping+1) itr.next
        itr.remove
    }
    itr.next.asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
