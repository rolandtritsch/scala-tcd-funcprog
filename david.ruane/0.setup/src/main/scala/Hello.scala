package ie.tcd.sccs.funcprog.setup

object Hello {
    def main(args: Array[String]): Unit = {
        try {
                println("Hello ".concat(args(0)))
        } catch {
            case e: ArrayIndexOutOfBoundsException =>
                println("Hello World")
        }
    }

    def incVal(i: Int): Int = {
        i + 1
    }
}
