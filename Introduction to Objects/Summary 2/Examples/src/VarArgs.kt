// Summary2/VarArgs.kt
package summary2
import atomictest.*

fun varargs(s: String, vararg ints: Int) {
  for (i in ints) {
    println("$i")
  }
  println(s)
}

fun main() {
  varargs("primes", 5, 7, 11, 13, 17, 19, 23)
  println eq "5 7 11 13 17 19 23 primes"
}