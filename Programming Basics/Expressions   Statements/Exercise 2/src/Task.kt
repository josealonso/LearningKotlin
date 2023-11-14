// ExpressionsStatements/Task2.kt
package expressionsAndStatementsExercise2

fun f(a: Int, b: Int) = a + b

fun g(a: String, b: String) = "$a$b"

fun h() = println("h()")

fun main() {
    val fRes: Int = f(2, 2)
    val gRes: String = g("Kot", "lin")
    val hRes: Unit = h()
    println("Int")
    println("String")
    println("Unit")
}