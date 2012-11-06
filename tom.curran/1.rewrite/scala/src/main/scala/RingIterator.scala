package ie.tcd.sccs.funcprog.josephus

/** Implements a simple ring iterator over a List.
 * 
 * When the iterator reaches the end of the list it
 * wraps over, means it effectively makes the List look
 * like a RingBuffer.
 *
 * The iterator also supports updates (add/remove) to the
 * RingBuffer.
 */
class RingIterator[T](var buffer: List[T], var currentPosition: Int) {
  def this() = this(List(), 0)
  
  private def addBefore(element: T, position: Int): Unit = {
    require(!buffer.isEmpty)
    require(element != null)
    require(position >= 0 && position < buffer.size)

    val (head, tail) = buffer.splitAt(position)
    buffer = head ::: List(element) ::: tail
  }

  private def addAfter(element: T, position: Int): Unit = {
    require(!buffer.isEmpty)
    require(element != null)
    require(position >= 0 && position < buffer.size)

    val (head, tail) = buffer.splitAt(position+1)
    buffer = head ::: List(element) ::: tail
  }

  private def remove(position: Int): Unit = {
    require(position >= 0 && position < buffer.size)

    val (head, tail) = buffer.splitAt(position)
    buffer = head ::: tail.drop(1)  
  }

  private def get(position: Int): T = {
    require(position >= 0 && position < buffer.size)

    buffer(position)
  }

  private def advanceCounterClockwise: Unit = {
    currentPosition = currentPosition - 1
    if(currentPosition < 0) currentPosition = buffer.size - 1
  }

  /** Add an element to the ring (after the current position).
   * 
   * Handles the case of the first element. After we added the
   * element into the ring the ring pointer points to the newly
   * added element.
   */
  def add(element: T): Unit = {
    require(element != null)
    
    if(buffer.isEmpty) {
      buffer = List(element)
      currentPosition = 0
    } else {
      this.addAfter(element, currentPosition)
      this.advance
    }

    assert(this.get == element)
  }

  /** Remove the element (at the current position) from the ring.
   *
   * Afterwards the ring pointer points to the element after the
   * one that got deleted (given that removing an element means
   * taking it out and moving the rest one forward we do not need
   * to move the ring pointer). After we have removed the element
   * the ring is either empty or the ring pointer points to the
   * element that was preceeding the element we removed.
   *  
   * Throws an exception if the ring is empty.
   */
  def remove: Unit = {
    if(buffer.isEmpty) throw new NoSuchElementException

    // remember the next element to test the post condition
    this.advance
    val nextElement = this.get
    this.advanceCounterClockwise

    remove(currentPosition)
    if(currentPosition >= buffer.size) currentPosition = 0

    assert(buffer.isEmpty || this.get == nextElement)
  }

  /** Advances the ring pointer (and warps over, if it has to).
   */
  def advance: Unit = {
    currentPosition = currentPosition + 1
    if(currentPosition >= buffer.size) currentPosition = 0
  }

  /** Get the element at the current ring position.
   *
   * Throws an exception, if there is no element.
   */
  def get: T = {
    if(buffer.isEmpty) throw new NoSuchElementException
    get(currentPosition)
  }

  /** Returns the size of the ring.
   */
  def size: Int = {
    buffer.size
  }

  /** Checks, if the ring is empty.
   */
  def isEmpty: Boolean = {
    buffer.isEmpty
  }

  /** Resets the ring pointer to a given position.
   */
  def reset(position: Int): Unit = {
    require(position >= 0 && (buffer.isEmpty || position < buffer.size))
    currentPosition = position
  }

  /** Returns an internal representation of the current buffer.
   *
   * This is for debugging and testing only.
   */
  def dump: List[T] = {
    val (head, tail) = buffer.splitAt(currentPosition)
    tail ::: head
  }
}
