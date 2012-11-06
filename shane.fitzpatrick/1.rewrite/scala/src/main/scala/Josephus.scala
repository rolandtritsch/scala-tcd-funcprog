package ie.tcd.sccs.funcprog.josephus

object Josephus {
    def def main(args: Array[String]): Unit = {
        assert(args.length === 2)

        val numOfSoliders: Int = args(0)
        val skipping: Int = args(1)

        println(findSurvivor(numOfSoliders, skipping-1))  
    }

    def findSurvivor(numOfSoliders: Int, skipping: Int): {
        theRing: List = Range(1, numOfSoliders+1).toList

        

    } 
}
