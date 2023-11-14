// Varargs/Task2.kt
package variableArgumentListsExercise2

fun printArgs(string: String, vararg nums: Int) {
    println("$string${nums.toList()}")
}

fun main() {
  printArgs("Numbers: ", 1, 2, 3)
}
/* Expected output:
Numbers: [1, 2, 3]
 */