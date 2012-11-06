package ie.tcd.sccs.funcprog.josephus

import scala.annotation.tailrec
// TODO import Java classes
import java.util.List
import java.util.LinkedList
import org.apache.commons.collections.iterators.LoopingListIterator

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)
	
    // TODO build linked list and put iterator on it
	val theRing = new LinkedList()

	val itr = new LoopingListIterator(theRing)
    for(i <- 1 to numOfSoldiers) itr.add(i)

	// TODO kill soldiers until one is left over and return it
	/*while(itr.size() != 1){
		for(j <- 1 to skipping+1){
			itr.next()
		}
		itr.remove()
	}

	return itr.next().asInstanceOf[Int]*/
	return survivorRecursion(itr, skipping)
  }
  
  @tailrec
  def survivorRecursion(itr: LoopingListIterator, skip: Int): Int = {
	if(itr.size() != 1){
		for(j <- 1 to skip+1){
			itr.next()
		}
		itr.remove()
		survivorRecursion(itr, skip)
	}else{
		return itr.next().asInstanceOf[Int]
	}
  } 

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
