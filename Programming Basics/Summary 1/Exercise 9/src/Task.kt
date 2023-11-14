// Summary1/Task9.kt
package summaryIExercise9

fun printTriangle(n: Int) {
    for (i in 1..n) {
//        var counter = 0
//        while (counter < i) {
        repeat(i) {
            print("#")
//            counter++
        }
        println()
    }

}

fun main() {
    printTriangle(4)
}
/* Output:
   #
  ###
 #####
#######
*/