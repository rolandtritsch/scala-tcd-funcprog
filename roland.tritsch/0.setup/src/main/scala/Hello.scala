package ie.tcd.sccs.funcprog.setup

object Hello {
  def main(args: Array[String]): Unit = {
    require(args.size == 1, "Need one argument")

    val who = args(0)
    println("Hello " + who)
  }

  def incVal(i: Int): Int = {
    i + 1
  }
}
