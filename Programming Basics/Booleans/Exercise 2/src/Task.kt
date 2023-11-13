// Booleans/Task2.kt
package booleansExercise2

fun showAnd(first: Boolean, second: Boolean) {
    println("$first && $second == ${first && second}")
}

fun showOr(first: Boolean, second: Boolean) {
    println("$first || $second == ${first || second}")
}

fun showTruthTable() {
    showAnd(true, true)
    showAnd(false, false)
    showAnd(true, false)
    showAnd(false, true)
    showOr(true, true)
    showOr(false, false)
    showOr(true, false)
    showOr(false, true)
}

fun main() {
    showTruthTable()
}