// Summary2/GetterAndSetter.kt
package summary2
import atomictest.*

class GetterAndSetter {
  var i: Int = 0
    get() {
      println("get()")
      return field
    }
    set(value) {
      println("set($value)")
      field = value
    }
}

fun main() {
  val gs = GetterAndSetter()
  gs.i = 2
  println(gs.i)
  println eq """
    set(2)
    get()
    2
  """
}