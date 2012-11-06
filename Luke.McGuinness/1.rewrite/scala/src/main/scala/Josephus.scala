package ie.tcd.sccs.funcprog.josephus

object Josephus {
    def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
        require(numOfSoldiers >= 1)
        require(skipping >= 0)
        val theRing = new RingIterator[Int]( List(), 0 )
        
        for (i <- 1 to numOfSoldiers) theRing.add(i)    
        
        theRing.reset(0)
        
        while (theRing.size > 1) {
            for(j <- 0 until skipping) theRing.advance
            
            theRing.remove  
        }
        theRing.get
    }

    def main(args: Array[String]): Unit = {
        require(args.length == 2);
        
        val numOfSoldiers: Int = args(0).toInt
        val killingEvery: Int = args(1).toInt
        
        println(findSurvivor(numOfSoldiers, killingEvery-1))
    }    
}
