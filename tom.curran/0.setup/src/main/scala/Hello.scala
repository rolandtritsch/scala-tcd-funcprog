package ie.tcd.sccs.funcprog.setup

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello " + args(0))
  }

  def incVal(i: Int): Int = {
    i + 1
  }
}
