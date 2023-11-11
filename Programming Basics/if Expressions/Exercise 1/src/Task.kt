// IfExpressions/Task1.kt
package ifExpressionsExercise1

fun checkSign(number: Int): String =
  if (number > 0) "positive"
  else if (number == 0) "zero"
  else "negative"

fun main() {
  println(checkSign(-19))  // negative
}