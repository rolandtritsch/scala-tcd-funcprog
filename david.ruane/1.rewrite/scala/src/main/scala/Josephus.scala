package ie.tcd.sccs.funcprog.josephus

object Josephus {
    def main(args: Array[String]): Unit = {
        val numSoldiers:Int = args(0).toInt
        val skip:Int = args(1).toInt
        println(findSurvivor(numSoldiers, skip))
    }
    def findSurvivor(n: Int, k: Int): Int = {
        var ring = new RingIterator((1 to n).toList, 0)
        ring.reset(0)
        while(ring.size > 1){
            for(x <- (1 until k)){
                ring.advance
            }
            ring.remove
        }
        ring.get
    }
}
