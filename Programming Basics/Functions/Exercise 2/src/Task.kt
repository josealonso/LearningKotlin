// Functions/Task2.kt
package functionsExercise2

fun getSum2(a: Double, b: Double, c: Double): Double = a + b + c

fun main() {
  println(getSum2(1.0, 2.2, 3.4))  // 6.6
  val res = sumCurried(2)(6)
  println(res)
  println(sumCurried2(2)(8))
}

// Curried function
fun sumNotCurried(a: Int, b: Int) = a + b

// Source: https://blog.devgenius.io/currying-in-kotlin-9be88bcc930d
fun sumCurried(a: Int): (Int) -> Int {
  return fun(b: Int): Int {
    return a + b
  }
}

fun sumCurried2(a: Int): (Int) -> Int =
  fun(b: Int): Int = a + b


