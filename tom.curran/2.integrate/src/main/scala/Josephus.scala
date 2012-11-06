package ie.tcd.sccs.funcprog.josephus

import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    // TODO build linked list and put iterator on it
    Collection theRing = new LinkedList();
    for(i <- 1 to numOfSoldiers) theRing.add(i)

    // TODO kill soldiers until one is left over and return it
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
