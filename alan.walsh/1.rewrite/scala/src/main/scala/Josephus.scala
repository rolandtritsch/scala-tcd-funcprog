package ie.tcd.sccs.funcprog.josephus

object Josephus {
  def main(args: Array[String]): Unit = { 
    val numOfSoldiers = args(0).toInt
	val skipping = args(1).toInt
	
	println(findSurvivor(numOfSoldiers, skipping))
  }
  def findSurvivor(numOfSoldiers:(Int), skipping:(Int)): Int = { 
    assert(numOfSoldiers.toInt >= 1)
	assert(skipping.toInt >= 0)
    val army = new RingIterator(Range(1,numOfSoldiers+1).toList, 0)
	while (army.size > 1){
	    //println("killed number "+army.get)
		for(i <- 0 until skipping){
		   //println("Skipped number "+army.get)
		   army.advance
		 }
	    army.remove
		   
	}
	//println("The last member of the army was number: "+army.get)
	army.get
  }
}
