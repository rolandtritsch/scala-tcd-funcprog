object Josephus {
    def main(args: Array[String]) {

    	if(args.size == 2){
			val numOfSoldiers = args(0).toInt;
			val killingEvery = args(1).toInt;
	  		println("Arguments passed!")
		}else{
	  		println("Invalid arguments!")		
		}
    }

	def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {

	}
}