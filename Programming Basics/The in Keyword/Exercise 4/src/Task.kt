// InKeyword/Task4.kt
package theInKeywordExercise4

fun isValidCharacter(c: Char): Boolean {
    return c == '_' || c.isLetterOrDigit()
}

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty() || s[0] in '0'..'9') return false
    for (ch in s) {
        if (!isValidCharacter(ch)) return false
    }
    return true
}

fun main() {
    println(isValidIdentifier("name"))  // true
    println(isValidIdentifier("0name"))  // false
}