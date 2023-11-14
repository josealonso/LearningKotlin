// Summary1/Task5.kt
package summaryIExercise5

fun everyFifth(start: Int, end: Int) {
    var result = ""
    for (num in start..end) {
        if ((num - start) % 5 == 4) println(num)
    }
}

fun main() {
    everyFifth(11, 30)
}
/* Output:
15
20
25
30
*/