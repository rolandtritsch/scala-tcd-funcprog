package ie.tcd.sccs.funcprog.josephus

import java.util.List
import java.util.LinkedList
import org.apache.commons.collections.iterators.{LoopingListIterator => RingIterator}

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    val l  = new LinkedList()
    var r = new RingIterator(l)

    for (i <- 1 to numOfSoldiers) {
      r.add(i)
    }
    r.reset
    while (r.size > 1) {
      for (i <- 1 to skipping+1) {
        r.next
      }
      r.remove
    }
    r.reset
    r.next.asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)
    println(findSurvivor(args(0).toInt, args(1).toInt - 1))
  }
}