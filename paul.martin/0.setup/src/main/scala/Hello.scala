package ie.tcd.sccs.funcprog.setup

object Hello {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) println("No arguments!")
    else println("Hello, " + args(0))
  }

  def incVal(i: Int): Int = {
    i + 1
  }
}
