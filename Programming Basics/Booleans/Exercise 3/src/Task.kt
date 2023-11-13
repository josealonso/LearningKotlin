// Booleans/Task3.kt
package booleansExercise3

fun and(b1: Boolean, b2: Boolean): Boolean =
  if (!b1) false else b2

fun or(b1: Boolean, b2: Boolean): Boolean =
  if (b1) true else b2

fun main() {
  println(and(true, true)) // true
  println(or(true, false)) // true
}