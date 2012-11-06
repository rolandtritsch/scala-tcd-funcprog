package ie.tcd.sccs.funcprog.josephus
import org.apache.commons.collections.iterators.LoopingListIterator
import java.util.LinkedList

// TODO import Java classes

object Josephus {
    def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
        require(numOfSoldiers >= 1)
        require(skipping >= 0)

        var mylist:LinkedList[Int] = new LinkedList()
        for(x <- (1 to numOfSoldiers)){
            mylist.add(x)
        }
        var ring = new LoopingListIterator(mylist)
        ring.reset
        while(ring.size > 1){
            for(x <- (0 to skipping)){
                    ring.next
            }
            ring.remove
        }
        mylist.get(ring.nextIndex)
    }

    def main(args: Array[String]): Unit = {
        assert(args.size == 2)

        val numOfSoldiers = args(0).toInt
        val killingEvery = args(1).toInt

        println(findSurvivor(numOfSoldiers, killingEvery-1))
    }
}
