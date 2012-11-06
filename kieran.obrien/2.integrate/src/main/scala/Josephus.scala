package ie.tcd.sccs.funcprog.josephus

// TODO import Java classes
import java.util.LinkedList
import java.util.{List => MyList}
import org.apache.commons.collections.iterators.LoopingListIterator

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    // TODO build linked list and put iterator on it
    val ringOfSoldiers = new LoopingListIterator(new LinkedList)
    for(i <- 1 to numOfSoldiers) ringOfSoldiers.add(i);
    
    // TODO kill soldiers until one is left over and return it
    while(ringOfSoldiers.size() > 1) {
        for (i <- 0 to skipping)
            ringOfSoldiers.next
        ringOfSoldiers.remove
    }
    ringOfSoldiers.next.asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
