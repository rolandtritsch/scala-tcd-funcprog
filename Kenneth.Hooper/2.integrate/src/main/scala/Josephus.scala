package ie.tcd.sccs.funcprog.josephus

import org.apache.commons.collections.iterators.LoopingListIterator

import java.util.{List, LinkedList}

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    var ringOfSoldiers : LinkedList[Int] = new LinkedList();
    for(i <- 1 to numOfSoldiers) ringOfSoldiers.add(i)
    
    var survivors = numOfSoldiers
    var iter = new LoopingListIterator(ringOfSoldiers)
    while(survivors > 1) {
        for(_ <- 0 to skipping) iter.next
        iter.remove
        survivors = survivors - 1
    }
    iter.next.asInstanceOf[Int]    
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
