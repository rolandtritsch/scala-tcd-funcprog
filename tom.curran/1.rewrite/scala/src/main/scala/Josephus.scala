package ie.tcd.sccs.funcprog.josephus

object Josephus {
    // TODO Implement solution here
    // HINT Use RingIterator
    
    def findSurvivor(numSol: Int, skip: Int): Int = {
        val ring = new RingIterator[Int]()
        
        for(i <- 1 to numSol) ring.add(i)
        ring.reset(0)
        
        while(ring.size > 1){
            for(i <- 1 until skip) ring.advance
            ring.remove
        }
        ring.get
    }
    
    def main(args: Array[String]): Unit = {
        assert(args.length == 2);
        
        val numSoldiers: Int = args(0).toInt
        val killingEvery: Int = args(1).toInt
        
        println(findSurvivor(numSoldiers, killingEvery))
    }
}
