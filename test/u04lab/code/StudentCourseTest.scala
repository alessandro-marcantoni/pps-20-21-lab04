package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List._

class StudentCourseTest {

  val course1: Course = Course("PPS", "Viroli")
  val course2: Course = Course("PCD", "Ricci")
  val student: Student = Student("Alessandro", 2020)

  @Test def courseComponentsTest(): Unit = {
    assertEquals("PPS", course1.name)
    assertEquals("Viroli", course1.teacher)
  }

  @Test def studentComponentTest(): Unit = {
    assertEquals("Alessandro", student.name)
    assertEquals(2020, student.year)
    assertEquals(nil, student.courses)
  }

  @Test def studentEnrollingTest(): Unit = {
    student.enrolling(course1, course2)
    assertEquals(Cons(course2.name, Cons(course1.name, nil)), student.courses)
  }

  @Test def studentHasTeacherTest(): Unit = {
    student.enrolling(course1)
    assertTrue(student.hasTeacher("Viroli"))
  }



}
