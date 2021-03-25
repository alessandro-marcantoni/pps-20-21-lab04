package u04lab.code

import Optionals._
import Lists._
import u04lab.code.Lists.List._
import u04lab.code.Optionals.Option._
import u04lab.code.Streams.Stream._
import u04lab.code.Streams._

trait PowerIterator[A] {
  def next(): Option[A]
  def allSoFar(): List[A]
  def reversed(): PowerIterator[A]
}

object PowerIterator {
  def apply[A](s: Stream[A]): PowerIterator[A] = PowerIteratorImpl(s)

  private case class PowerIteratorImpl[A](private var stream: Stream[A]) extends PowerIterator[A] {
    private var pastList: List[A] = nil

    override def next(): Option[A] = {
      val next = head(stream)
      stream = tail(stream)
      applyIfPresent(next)(e => pastList = append(pastList, List.Cons(e, nil)))
      next
    }

    override def allSoFar(): List[A] = pastList

    override def reversed(): PowerIterator[A] = new PowerIteratorsFactoryImpl().fromList(reverse(pastList))
  }
}

trait PowerIteratorsFactory {

  def incremental(start: Int, successive: Int => Int): PowerIterator[Int]
  def fromList[A](list: List[A]): PowerIterator[A]
  def randomBooleans(size: Int): PowerIterator[Boolean]
}

class PowerIteratorsFactoryImpl extends PowerIteratorsFactory {

  override def incremental(start: Int, successive: Int => Int): PowerIterator[Int] = PowerIterator(iterate(start)(successive))

  override def fromList[A](list: List[A]): PowerIterator[A] = PowerIterator(Stream.fromList(list))

  override def randomBooleans(size: Int): PowerIterator[Boolean] = PowerIterator(take(generate(Math.random() < 0.5))(size))
}
