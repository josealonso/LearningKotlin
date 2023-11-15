// PropertyAccessors/Default.kt
package propertyaccessors
import atomictest.*

class Default {
  var i: Int = 0
    get() {
      println("get()")
      return field       // [1]
    }
    set(value) {
      println("set($value)")
      field = value      // [2]
    }
}

fun main() {
  val d = Default()
  d.i = 2
  println(d.i)
  println eq """
    set(2)
    get()
    2
  """
}