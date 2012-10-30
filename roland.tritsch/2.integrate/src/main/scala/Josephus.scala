package ie.tcd.sccs.funcprog.josephus

import org.apache.commons.collections.iterators.LoopingListIterator
import java.util.{List => JList, LinkedList => JLinkedList}
import java.lang.{Integer => JInteger}

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    assert(numOfSoldiers >= 1)
    assert(skipping >= 0)

    val soldiers: JList[JInteger] = new JLinkedList[JInteger]()
    for(i <- 1 to numOfSoldiers) soldiers.add(new JInteger(i))
    val theRing = new LoopingListIterator(soldiers)

    theRing.reset
    while(theRing.size > 1) {
      for(i <- 0 to skipping) theRing.next
      theRing.remove
    }

    theRing.next.asInstanceOf[JInteger]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
