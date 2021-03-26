package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue, fail}
import org.junit.jupiter.api.Test
import u04lab.code.Lists._

class SameTeacherTest {

  val course1: Course = Course("PPS", "Viroli")
  val course2: Course = Course("OOP", "Viroli")
  val course3: Course = Course("PCD", "Ricci")
  val course4: Course = Course("SEIoT", "Ricci")

  @Test def matchTest(): Unit = {
    List(List.of(course1), List.of(course2)) match {
      case SameTeacher(t) => assertEquals(course1.teacher, t)
      case _ => fail()
    }
    List(List.of(course3), List.of(course4)) match {
      case SameTeacher(t) => assertEquals(course3.teacher, t)
      case _ => fail()
    }
    List.of(course1) match {
      case SameTeacher(_) => assertTrue(true)
      case _ => fail()
    }
  }

  @Test def notMatchTest(): Unit = {
    List(List.of(course1), List.of(course3)) match {
      case SameTeacher(_) => fail()
      case _ => assertTrue(true)
    }
    List(List.of(course1), List.of(course2), List.of(course3), List.of(course4)) match {
      case SameTeacher(_) => fail()
      case _ => assertTrue(true)
    }
  }



}
