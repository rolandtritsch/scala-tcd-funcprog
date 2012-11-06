package ie.tcd.sccs.funcprog.josephus

import org.scalatest._

class RingIteratorSpec extends FlatSpec with BeforeAndAfter {
  var ring: RingIterator[Int] = _

  before {
    ring = new RingIterator[Int]()
    ring.add(100)
    ring.add(200)
    ring.add(300)
  }

  "RingIterator" should "allow you to add elements" in {
    assert(ring.size === 3)
  }

  it should "maintain/update the current position while adding elements" in {
    assert(ring.get === 300)
  }

  it should "allow you to access all elements of the ring" in {
    assert(ring.get === 300)
    ring.advance
    assert(ring.get === 100)
    ring.advance
    assert(ring.get === 200)
    ring.advance
    assert(ring.get === 300)
    ring.advance
    assert(ring.get === 100)
  }

  it should "allow to insert new elements at any point in the ring" in {
    ring.advance
    ring.add(150)
    ring.advance
    ring.add(250)
    ring.advance
    ring.add(350)
    ring.add(50)

    assert(ring.get === 50)
    ring.advance
    assert(ring.get === 100)
    ring.advance
    assert(ring.get === 150)
    ring.advance
    assert(ring.get === 200)
    ring.advance
    assert(ring.get === 250)
    ring.advance
    assert(ring.get === 300)
    ring.advance
    assert(ring.get === 350)
    ring.advance
    assert(ring.get === 50)
  }

  it should "allow to remove elements from any point in the ring" in {
    ring.advance
    ring.add(150)
    ring.advance
    ring.add(250)
    ring.advance
    ring.add(350)
    ring.add(50)
    // println(ring.dump.mkString(","))

    assert(ring.get === 50)
    ring.remove
    assert(ring.get === 100)
    ring.remove
    assert(ring.get === 150)
    ring.advance
    ring.remove
    assert(ring.get === 250)
    ring.remove
    assert(ring.get === 300)
    ring.remove
    assert(ring.get === 350)
    ring.remove
    assert(ring.get === 150)
    assert(ring.size === 1)
    ring.advance
    assert(ring.get === 150)
    ring.remove
    assert(ring.size === 0)
   }

  it should "throw an exception if you try to remove an element from an empty ring" in {
    intercept[NoSuchElementException] {
      for(i <- 0 to ring.size) ring.remove
    }
  }

  it should "throw an exception if you try to get an element from an empty ring" in {
    intercept[NoSuchElementException] {
      for(i <- 0 until ring.size) ring.remove
      ring.get
    }
  }
}
