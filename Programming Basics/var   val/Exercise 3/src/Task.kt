// VarAndVal/Task3.kt
package varAndValExercise3

fun main() {
  var x = 1
  var y = 2
//  x = y; y = x
  val aux = x
  val aux2 = y
  y = aux
  x = aux2
  println(x)
  println(y)
}