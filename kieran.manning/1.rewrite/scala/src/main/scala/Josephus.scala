package ie.tcd.sccs.funcprog.josephus


object Josephus {
    def findSurivor(var numOfSolider: Int, var skipping: Int):Int = {
        require(numOfSoldiers >= 1)
        require(skipping >= 0)

        var ringBuffer = ringBuffer[Int] = _
        
        for(i <- 0
    }
}
