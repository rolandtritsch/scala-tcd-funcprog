package ie.tcd.sccs.funcprog.josephus


object Josephus {


    def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
        require(numOfSoldiers >= 1)
        require(skipping >= 0)

        val ringBuffer = new RingIterator(Range(1, (numOfSoldiers + 1)).toList, 0)
        
        ringBuffer.reset(0)

        while(ringBuffer.size > 1){
            for(i <- 0 until skipping) {
                ringBuffer.advance
            }
            ringBuffer.remove
        }
        ringBuffer.get 
    }

    def main(args: Array[String]){
        require(args.length == 2)
        
        println(findSurvivor(args(0).toInt, args(1).toInt - 1))
    }
}

