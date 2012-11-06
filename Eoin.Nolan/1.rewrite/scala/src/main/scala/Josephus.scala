package ie.tcd.sccs.funcprog.josephus

object Josephus {
    def main(args: Array[String]) {

    	if(args.size == 2){
			val numOfSoldiers = args(0).toInt;
			val killingEvery = args(1).toInt;
	  		println("Arguments passed!")
	  		println("Survivor @: " + findSurvivor(numOfSoldiers, killingEvery));
		}else{
	  		println("Invalid arguments!")		
		}
    }

	def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {

		val soldiers = Range(1, numOfSoldiers + 1).toList;
		val iterator = new RingIterator[Int](soldiers, 0);

		while(iterator.size > 1){
			for(i <- 1 until skipping){
				iterator.advance;
			}
			iterator.remove;
		}

		return iterator.get;
	}
}
