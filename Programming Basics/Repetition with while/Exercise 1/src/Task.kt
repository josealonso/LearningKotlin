// RepetitionWithWhile/Task1.kt
package repetitionWithWhileExercise1

fun displayContent(str: String) {
    var index = 0
    while (index < str.length) {
        println(str[index])
        index++
    }

}

fun main() {
    displayContent("abc")
}
/* Expected output:
a
b
c
*/