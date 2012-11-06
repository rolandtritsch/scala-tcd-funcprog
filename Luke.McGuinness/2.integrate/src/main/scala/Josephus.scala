package ie.tcd.sccs.funcprog.josephus

// TODO import Java classes
import java.util.LinkedList
import java.util.{List => Jlist}
import org.apache.commons.collections.iterators.LoopingListIterator 

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)
   // val jlist: java.util.List[Int]
    
    // TODO build linked list and put iterator on it
    var list = new LinkedList()
    val theRing = new LoopingListIterator(list)
    for (i <- 1 to numOfSoldiers) theRing.add(i)   
    
    theRing.reset() 
    // TODO kill soldiers until one is left over and return it
    while (theRing.size > 1) {
        for(j <- 0 to skipping) theRing.next()
        theRing.remove()
    }
    theRing.next.asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
