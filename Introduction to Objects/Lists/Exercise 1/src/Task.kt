// Lists/Task1.kt
package listsExercise1

import atomictest.eq

fun findMax(list: IntList): Int {
    var index = 0
    var max = 0
//    if (list.size() == 0) return 0
//    else {
//        while (index < list.size() - 1) {
//            if (list[index] > list[index + 1]) max = list[index] else max = list[index + 1]
//            index++
//        }
//    }
    for (e in list) {
      if (e >= max) max = e
    }
    return max
}

fun main() {
    val list = IntList(listOf(1, 2, 3, 2))
    findMax(list) eq 3
}