package u04lab.code

import Lists.List
import Lists.List._

object VariableList {

  object VariableList {
    def apply[A](lists: List[A]*): List[A] = {
      var result: List[A] = nil
      lists.foreach(l => result = append(result, l))
      result
    }
  }

}
