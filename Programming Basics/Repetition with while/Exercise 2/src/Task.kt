// RepetitionWithWhile/Task2.kt
package repetitionWithWhileExercise2

fun sum(number: Int): Int {
    var result = 0
    var index = 0
    while (index < number) {
        index++
        result += index
    }
    return result
}

fun main() {
    println(sum(10))  // 55
}