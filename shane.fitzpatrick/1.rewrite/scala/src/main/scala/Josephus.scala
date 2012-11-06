package ie.tcd.sccs.funcprog.josephus

object Josephus {
    def main(args: Array[String]): Unit = {
        assert(args.length == 2)

        val numOfSoliders: Int = args(0).toInt
        val skipping: Int = args(1).toInt

        println(findSurvivor(numOfSoliders, skipping-1))  
    }

    def findSurvivor(numOfSoliders: Int, skipping: Int): Int = {
        var theRing = Range(1, numOfSoliders+1).toList
        var itr = new RingIterator[Int](theRing, 0)
        
        while(itr.size > 1) {
            println(itr.dump)
            for(_ <- 0 to skipping-1) { itr.advance }
            itr.remove
        }
        
        itr.get
    } 
}
