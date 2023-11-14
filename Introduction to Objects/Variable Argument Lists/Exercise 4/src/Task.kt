// Varargs/Task4.kt
package variableArgumentListsExercise4

import atomictest.eq

fun flatten(listOfLists: List<List<String>>): List<String> {
//    var str = listOfLists.joinToString(",", "[","]")
    var list = mutableListOf<String>()
    for (elem in listOfLists) {
        list.addAll(elem)
    }
    println("AAA: $list")
    return list
}

fun main() {
    val listOfLists = listOf(listOf("a", "b"), listOf("c", "d"))
    flatten(listOfLists) eq listOf("a", "b", "c", "d")
}