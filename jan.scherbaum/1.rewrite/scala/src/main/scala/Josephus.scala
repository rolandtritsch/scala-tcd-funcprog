package ie.tcd.sccs.funcprog.josephus

object Josephus {
	def main(args: Array[String]): Unit = {
		assert(args.length >= 2)
    		val numOfSoldiers = args(0).toInt	
		val skipping = args(1).toInt
		
		println(findSurvivor(numOfSoldiers, skipping))
	}

	def findSurvivor(numOfSoldiers : Int, skipping : Int): Int = {
		assert(numOfSoldiers >= 1);
		assert(skipping >= 0);

		val iter = new RingIterator((Range(1, numOfSoldiers+1)).toList, 0)

		iter.reset(0)
		while(iter.size != 1) {
			for(i <- 0 until skipping) {
				iter.advance
			}
			iter.remove
		}
		return iter.get
	}

}
