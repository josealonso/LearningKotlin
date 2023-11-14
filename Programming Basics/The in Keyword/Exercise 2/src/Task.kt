// InKeyword/Task2.kt
package theInKeywordExercise2

fun sumOfEven(n: Int): Int {
    var result = 0
    for (num in 0..n step 2) result += num
    return result
}

fun main() {
    println(sumOfEven(10))  // 30
}