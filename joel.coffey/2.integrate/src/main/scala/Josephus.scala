package ie.tcd.sccs.funcprog.josephus

import java.util.List
import java.util.LinkedList
import org.apache.commons.collections.iterators.LoopingListIterator

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    val list  = new LinkedList()
    val itr = new LoopingListIterator(list)

    Range(1, numOfSoldiers+1).foreach(itr.add)
    itr.reset

    while (itr.size > 1) {
      for (_ <- 1 to skipping+1) { itr.next }
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
