package u04lab.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComplexTest {

  val complex1: Complex = Complex(10.0, 20.0)
  val complex2: Complex = Complex(1.0, 2.0)

  @Test def componentsTest(): Unit = {
    assertEquals(10.0, complex1.re)
    assertEquals(20.0, complex1.im)
  }

  @Test def sumTestNoEquality(): Unit = {
    val complexSum: Complex = complex1 + complex2
    assertEquals(11.0, complexSum.re)
    assertEquals(22.0, complexSum.im)
  }

  @Test def productTestNoEquality(): Unit = {
    val complexProduct: Complex = complex1 * complex2
    assertEquals(-30.0, complexProduct.re)
    assertEquals(40.0, complexProduct.im)
  }

  @Test def sumTestWithEquality(): Unit = {
    assertEquals(Complex(11.0, 22.0), complex1 + complex2)
  }

  @Test def productTestWithEquality(): Unit = {
    assertEquals(Complex(-30.0, 40.0), complex1 * complex2)
  }

  @Test def toStringTest(): Unit = {
    println(complex1.toString)
  }

}
