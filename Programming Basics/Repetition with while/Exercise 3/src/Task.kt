// RepetitionWithWhile/Task3.kt
package repetitionWithWhileExercise3

fun sumOfEven(n: Int): Int {
    var index = 0
    var result = 0

    while (index < n) {
        index++
        if (index % 2 == 0) result += index
    }
    return result
}

fun main() {
    println(sumOfEven(10))  // 30
}