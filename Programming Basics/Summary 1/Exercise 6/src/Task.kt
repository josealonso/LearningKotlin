// Summary1/Task6.kt
package summaryIExercise6

fun everyFifthNonSpace(s: String) {
    var i = 1
    for (ch in s) {
        if (ch != ' ' && i % 5 == 0) println(ch)
        if (ch != ' ') i++
    }
}

fun main() {
    everyFifthNonSpace("abc d e fgh ik")
}
/* Output:
e
k
*/