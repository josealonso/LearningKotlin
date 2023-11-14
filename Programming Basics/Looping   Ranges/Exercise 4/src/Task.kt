// LoopingAndRanges/Task4.kt
package loopingAndRangesExercise4

fun showHalfTriangle(n: Int) {
    var index = 0
    var symbol = ""
    for (i in 1..n) {
        while (index < i) {
            symbol += "#"
            index++
        }
        println(symbol)
    }
}

fun showHalfTriangle2(n: Int) {
    for (i in 1..n) {
        repeat(i) {
            print("#")
        }
            println()
    }
}

fun main() {
    showHalfTriangle(4)
    showHalfTriangle2(4)
}
/* Output:
#
##
###
####
*/