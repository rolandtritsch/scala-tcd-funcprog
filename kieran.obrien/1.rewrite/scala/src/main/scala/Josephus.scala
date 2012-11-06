package ie.tcd.sccs.funcprog.josephus

object Josephus {
    def findSurvivor(numOfSoldiers: Int, skipping: Int):Int = {
        require(numOfSoldiers >=1)
        require(skipping >= 0)
    
        val ringOfSoldiers = new RingIterator[Int]((1 to numOfSoldiers).toList,0)
        
        while(ringOfSoldiers.size > 1) {
            for (i <- 0 until skipping) {
                //if ()
                ringOfSoldiers.advance
            }
            ringOfSoldiers.remove
        }
        ringOfSoldiers.get
    }

    
    def main(args: Array[String]): Unit = {
        require(args.length == 2)
        
        val numOfSoldiers: Int = Integer.parseInt(args(0));
        val killingEvery: Int = Integer.parseInt(args(1));
        
        println(findSurvivor(numOfSoldiers, killingEvery-1))
    }
    
}
