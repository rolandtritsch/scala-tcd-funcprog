package ie.tcd.sccs.funcprog.josephus

object Josephus {
  def main(args: Array[String]): Unit = {
    val numOfSoldiers = Integer.parseInt(args(0));
    val killingEvery = Integer.parseInt(args(1));

    System.out.println(findSurvivor(numOfSoldiers, killingEvery-1));
  }

  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    val ring = new RingIterator[Int](Range(1, numOfSoldiers+1).toList, 0)
    while (ring.size > 1) {
      for (_ <- 1 to skipping) { ring.advance }
      ring.remove
    }
    ring.get
  }
}