// Sets/Task2.kt
package setsExercise2

import kotlin.random.Random

fun experiment(): Int {
    var counter = 0
    val set = mutableSetOf<Int>()
    while (set.size < 25) {
        set.add(Random.nextInt(25) + 1)
        counter++
    }
    return counter
}

fun main() {
    val counts = mutableListOf<Int>()
    repeat(1000) {
        counts += experiment()
    }
    println(counts.average())
}