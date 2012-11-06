package ie.tcd.sccs.funcprog.josephus

import java.util.List
import java.util.LinkedList
import org.apache.commons.collections.iterators.LoopingListIterator

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    // build linked list and put iterator on it
    var list = new LinkedList()
    var itr = new LoopingListIterator(list)
    for (i <- 1 to numOfSoldiers) itr.add(i)

    // kill soldiers until one is left over and return it
    while(itr.size() > 1) {
      for(_ <- 0 to skipping) { itr.next() }
      itr.remove()
    }
    return itr.next().asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
