// NumberTypes/Task4.kt
package numberTypesExercise4

val MILLISECONDS_IN_A_SECOND = 1000L
val SECONDS_IN_A_MINUTE = 60L
fun convertToMilliseconds(hours: Int, minutes: Int, seconds: Int): Long =
  (seconds + SECONDS_IN_A_MINUTE * (minutes + hours * 60L)) * MILLISECONDS_IN_A_SECOND

fun main() {
  println(convertToMilliseconds(1, 30, 0))
}