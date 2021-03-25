package u04lab.code

import org.junit.jupiter.api.Test
import u04lab.code.Lists.List._
import VariableList.VariableList
import org.junit.jupiter.api.Assertions.assertEquals

class VariableListTest {

  @Test def variableListTest(): Unit = {
    val list1 = Cons(0, nil)
    val list2 = Cons(1, nil)
    val list3 = Cons(2, nil)
    val list4 = Cons(3, nil)
    assertEquals(
      Cons(0,Cons(1,Cons(2,Cons(3,Nil())))),
      VariableList(list1, list2, list3, list4)
    )
    assertEquals(
      nil,
      VariableList()
    )
  }

}
