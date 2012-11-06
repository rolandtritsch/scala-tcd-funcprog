package ie.tcd.sccs.funcprog.setup

object Hello {
  def main(args: Array[String]): Unit = {
    var a = ""
    a += args
    println("Hello " + a)
  }

  def incVal(i: Int): Int = {
    i + 1
  }
}
