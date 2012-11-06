package ie.tcd.sccs.funcprog.josephus

import java.util.List
import java.util.LinkedList
import org.apache.commons.collections.iterators.LoopingListIterator

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    // TODO build linked list and put iterator on it
    var ringBuffer:LinkedList[Integer] = new LinkedList()
    for(i <- 1 to numOfSoldiers) ringBuffer.add(i)
    var itr = new LoopingListIterator(ringBuffer)
    itr.reset()
    // TODO kill soldiers until one is left over and return it
    while(ringBuffer.size > 1){
      for(i <- 0 to skipping) {
        itr.next
      }
      itr.remove
    }
    ringBuffer.get(itr.nextIndex())
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
