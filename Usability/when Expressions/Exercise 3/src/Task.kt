// WhenExpressions/Task3.kt
package whenExpressionsExercise3

import atomictest.eq

fun balanced(input: String): Boolean {
    var closingParens = 0
    var openingParens = 0
    for (char in input) {
        if (char == ')') closingParens++
        if (char == '(') openingParens++
    }
    return openingParens == closingParens
}

fun main() {
    balanced("(()) ()") eq true
    balanced(")(") eq false
}