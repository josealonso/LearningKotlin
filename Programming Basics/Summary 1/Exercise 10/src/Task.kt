// Summary1/Task10.kt
package summaryIExercise10

fun showSnake(rows: Int, columns: Int) {
    var counter = 0
    for (row in 1..rows) {
        for (col in 1..columns) {
            print("%3d".format(counter))
            counter++
        }
        println()
    }
}

fun main() {
    showSnake(2, 3)
    println()
    showSnake(4, 5)
}
/* Output:
 0 1 2
 5 4 3

  0  1  2  3  4
  9  8  7  6  5
 10 11 12 13 14
 19 18 17 16 15
*/