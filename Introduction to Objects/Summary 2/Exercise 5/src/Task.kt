// Summary2/Task5.kt
package summaryIIExercise5

fun va1(vararg params: Int) {
    println("va1:")
    for (i in params) {
        println(i)
    }
}

fun va2(vararg params: Int) {
    println("va2:")
    va1(*params)  // It won't compile without asterisk
}

fun main() {
    va1(1, 2, 3)
    va2(4, 5, 6)
}
/* Expected output:
va1:
1
2
3
va2:
va1:
4
5
6
 */