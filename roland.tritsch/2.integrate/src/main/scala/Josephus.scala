package ie.tcd.sccs.funcprog.josephus



object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    val soldiers: JList[JInteger] = new JLinkedList[JInteger]()
    for(i <- 1 to numOfSoldiers) soldiers.add(new JInteger(i))
    val ringOfSoldiers = new LoopingListIterator(soldiers)

    ringOfSoldiers.reset
    while(ringOfSoldiers.size > 1) {
      for(i <- 0 to skipping) ringOfSoldiers.next
      ringOfSoldiers.remove
    }
    
    assert(ringOfSoldiers.size == 1)
    ringOfSoldiers.next.asInstanceOf[JInteger]
  }

  def findSurvivorRecursively(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    val soldiers: JList[JInteger] = new JLinkedList[JInteger]()
    for(i <- 1 to numOfSoldiers) soldiers.add(new JInteger(i))
    val ringOfSoldiers = new LoopingListIterator(soldiers)

    def findSurvivorRecursion: Int = {
      require(ringOfSoldiers.size >= 1)

      if(ringOfSoldiers.size == 1) ringOfSoldiers.next.asInstanceOf[JInteger]
      else {
        for(i <- 0 to skipping) ringOfSoldiers.next
        ringOfSoldiers.remove
	findSurvivorRecursion
      }
    }

    findSurvivorRecursion
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
    println(findSurvivorRecursively(numOfSoldiers, killingEvery-1))
  }
}
