package u04lab.code

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u04lab.code.Lists._
import u04lab.code.Optionals._

class PowerIteratorsTest {

  val factory = new PowerIteratorsFactoryImpl()

  @Test def testIncremental(): Unit = {
    val pi = factory.incremental(5, _ + 2) // pi produce 5,7,9,11,13,...
    assertEquals(Option.of(5), pi.next())
    assertEquals(Option.of(7), pi.next())
    assertEquals(Option.of(9), pi.next())
    assertEquals(Option.of(11), pi.next())
    assertEquals(List.Cons(5, List.Cons(7, List.Cons(9, List.Cons(11, List.Nil())))), pi.allSoFar()) // elementi già prodotti
    for (i <- 0 until 10) {
      pi.next() // procedo in avanti per un po'..
    }
    assertEquals(Option.of(33), pi.next()) // sono arrivato a 33

    val revPi = pi.reversed()
    assertEquals(Option.of(33), revPi.next())
    assertEquals(Option.of(31), revPi.next())
  }

  @Test def testRandomBooleans(): Unit = {
    val bool = factory.randomBooleans(10)
    println(bool.next())
    println(bool.next())
    for (i <- 0 until 7) {
      bool.next() // procedo in avanti per un po'..
    }
    println(bool.next())
    println(bool.next())
  }
}