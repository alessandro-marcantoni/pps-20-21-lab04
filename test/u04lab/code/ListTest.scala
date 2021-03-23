package u04lab.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u04lab.code.Lists._
import u04lab.code.Lists.List.{Cons, appendByFold, filterByFlatmap, length, nil}

class ListTest {

  val list: List[Int] = Cons(1, Cons(2, Cons(3, nil)))

  @Test def lengthTest(): Unit = {
    assertEquals(3, length(list))
  }

  @Test def filterByFlatmapTest(): Unit = {
    assertEquals(Cons(3, nil), filterByFlatmap(list)(_>2))
  }

  @Test def appendByFoldTest(): Unit = {
    assertEquals(
      Cons(1, Cons(2, Cons(3, Cons(4, nil)))),
      appendByFold(list, Cons(4, nil))
    )
  }

}
