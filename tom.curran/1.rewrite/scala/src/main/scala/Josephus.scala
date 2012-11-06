package ie.tcd.sccs.funcprog.josephus

object Josephus {    
    def findSurvivor(numSol: Int, skip: Int): Int = {
        assert(numSol >= 1)
        assert(skip >= 0)
        
        val ring = new RingIterator[Int]((1 to numSol).toList, 0)
        
        while(ring.size > 1){
            for(i <- 1 until skip) ring.advance
            ring.remove
        }
        ring.get
    }
    
    def main(args: Array[String]): Unit = {
        assert(args.length == 2);        
        println(findSurvivor(args(0).toInt, args(1).toInt))
    }
}
