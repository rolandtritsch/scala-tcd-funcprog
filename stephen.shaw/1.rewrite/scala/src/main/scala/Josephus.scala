package ie.tcd.sccs.funcprog.josephus

object Josephus {
    // TODO Implement solution here
    // HINT Use RingIterator
    def main(args: Array[String]): Unit = {
        val numOfSoldiers = args(0).toInt
        val killingEvery = args(1).toInt
        println(findSurvivor(numOfSoldiers, killingEvery-1))
    }


    def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
        val theRing = new RingIterator[Int]();

        for(i <- 1 to numOfSoldiers) {
            theRing.add(i)
        }

        theRing.advance


        while (theRing.size > 1) {
            for (j <- 1 to skipping) theRing.advance

            theRing.remove
        }

        theRing.get
    }

}

