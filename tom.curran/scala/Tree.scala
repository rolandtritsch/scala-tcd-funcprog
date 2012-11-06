abstract class TreeNode
case class Node(left: TreeNode, right: TreeNode) extends TreeNode
case class Leaf(data: Int) extends TreeNode

object Tree {
  val left = new Leaf(1)
  val right = new Leaf(2)
  val root = new Node(left, right)

  def dump(t: TreeNode): String = {
    t match {
      case Node(l, r) => "left(" + dump(l) + "):right(" + dump(r) + ")"
      case Leaf(d) => d.toString
    }
  }
}
