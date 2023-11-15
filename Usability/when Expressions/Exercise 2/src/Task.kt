// WhenExpressions/Task2.kt
package whenExpressionsExercise2
import atomictest.eq

fun temperature(temperature: Int): String =
  when {
    temperature in -5..4 -> "Cold"
    temperature in 5..14 -> "Cool"
    temperature in 15..24 -> "Warm"
    temperature > 25 -> "Hot"
    else -> "Freezing"
  }

fun main() {
  temperature(30) eq "Hot"
  temperature(10) eq "Cool"
  temperature(-30) eq "Freezing"
}