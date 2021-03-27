package u04lab.code

import org.junit.jupiter.api.Test
import u04lab.code.Lists.List._
import u04lab.code.Lists._
import org.junit.jupiter.api.Assertions.assertEquals

class VariableListTest {

  @Test def variableListTest(): Unit = {
    assertEquals(
      Cons(0,Cons(1,Cons(2,Cons(3,Nil())))),
      List(0, 1, 2, 3)
    )
    assertEquals(
      nil,
      List()
    )
  }

}
