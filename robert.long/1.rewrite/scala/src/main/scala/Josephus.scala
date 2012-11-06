package ie.tcd.sccs.funcprog.josephus

object Josephus {

    def findSurvivor(numOfSoldiers:Int, skipping:Int) : Int = {
      
      var r = new RingIterator[Int]()

      for (i <- 1 to numOfSoldiers) {
        r.add(i)
      }
      r.reset(0)
      for(j <- numOfSoldiers until 1 by -1) {
        for (i <- 0 until skipping) {
          r.advance
        }
        r.remove
      }
      r.reset(0)
      r.get
    }

    def main(args: Array[String]): Unit = {
      println(findSurvivor(args(0).toInt, args(1).toInt))
    }

}
