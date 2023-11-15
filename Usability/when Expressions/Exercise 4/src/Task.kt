// WhenExpressions/Task4.kt
package whenExpressionsExercise4
import atomictest.eq

fun getBmiStatus(
  kg: Double,
  heightM: Double
): String {
  val bmi = kg / (heightM * heightM)
  return if (bmi < 18.5) "Underweight"
  else if (bmi < 25) "Normal weight"
  else "Overweight"
}

fun main() {
  getBmiStatus(72.57, 1.727) eq "Normal weight"
}