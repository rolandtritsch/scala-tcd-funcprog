package ie.tcd.sccs.funcprog.josephus

object Josephus {
    // TODO Implement solution here
    // HINT Use RingIterator

	def main(args: Array[String]): Unit = {
		assert(args.size == 2)	

		val numSoldiers = args(0).toInt 
		val killingEvery = args(1).toInt	

		println("Survivor: " + josephys(numSoldiers, killingEvery))
		println("Num: " + numSoldiers + " KillingEvery: " + killingEvery)
	}

	def josephys(num: Int, every: Int): Int = {
		val itr = new RingIterator(Range(1,num+1).toList, 0)

		while (itr.size != 1){
			for (i <- 1 until every){
				itr.advance
			}
			itr.remove
		}
		println("RingIterator: " + itr.dump)		

		return itr.get
	}
}
