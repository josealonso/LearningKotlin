// Functions/Task4.kt
package functionsExercise4

/*
  A function can be written in two different ways
 */
fun foo2(): String = "abc"   // expression body
fun foo(): String {          // block body
  return "abc"
}

fun main() {
  println(foo())
}