// WhenExpressions/MatchingAgainstVals.kt
import atomictest.*

fun main() {
  val yes = "A"
  val no = "B"
  for (choice in listOf(yes, no, yes)) {
    when (choice) {
      yes -> println("Hooray!")
      no -> println("Too bad!")
    }
    // The same logic using 'if':
    if (choice == yes) println("Hooray!")
    else if (choice == no) println("Too bad!")
  }
  println eq """
    Hooray!
    Hooray!
    Too bad!
    Too bad!
    Hooray!
    Hooray!
  """
}