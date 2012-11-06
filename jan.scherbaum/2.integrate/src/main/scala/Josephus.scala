package ie.tcd.sccs.funcprog.josephus

import java.util._
import scala.util.logging.{Logged, ConsoleLogger}
import org.apache.commons.collections.iterators._

//object Josephus extends Logged with ConsoleLogger {
object Josephus extends Logged {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    val lst = new java.util.LinkedList[Int]
    for(i <- 1 to numOfSoldiers) {
	lst.add(i)
    }
	log("init done..")

    val iter = new LoopingListIterator(lst)

    iter.reset
		while(iter.size != 1) {
			for(i <- 0 to skipping) {
				iter.next
			}
			iter.remove
		}

    return lst.get(0)
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
