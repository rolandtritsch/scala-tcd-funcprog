package ie.tcd.sccs.funcprog.josephus

object Josephus {
    // TODO Implement solution here
    // HINT Use RingIterator
    def findSurvivor(soldiers : Int, skipping : Int) : Int = {
        require(soldiers >= 1)
        require(skipping > 0)
        
        var ringofsoldiers : RingIterator[Int] = new RingIterator[Int]
        
        for(i <- 1 to soldiers) ringofsoldiers.add(i)
        
        var survivors = soldiers
        ringofsoldiers.reset(0)
        
        while(survivors > 1){
            for(_ <- 1 until skipping) ringofsoldiers.advance
            ringofsoldiers.remove
            survivors = survivors - 1
        }
        
        ringofsoldiers.get

    }
    
    def main(args : Array[String]): Unit = {
        require(args.size == 2)
        
        val surv : Int = args(0).toInt
        val skip : Int = args(1).toInt
        println(findSurvivor(surv, skip))
    }
}
