package u04lab.code

import u04lab.code.Lists.List._
import u04lab.code.Lists._

object SameTeacher {

  def unapply(courses: List[Course]): Option[String] = map(courses)(_.teacher) match {
    case Cons(h, t) if allMatch(t)(_ == h) => Some(h)
    case _ => None
  }

}
