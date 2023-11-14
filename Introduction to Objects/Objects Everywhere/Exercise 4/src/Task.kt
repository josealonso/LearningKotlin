// ObjectsEverywhere/Task4.kt
package objectsEverywhereExercise4


fun reverseDecimal(number: Int): Int {
    val str = number.toString();
    val strReversed = str.reversed()
    return strReversed.toInt()
}

fun main() {
    println(reverseDecimal(1234))  // 4321
}