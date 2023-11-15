// Sets/Task1.kt
package setsExercise1
import atomictest.eq

fun hasUniqueCharacters(s: String): Boolean {
 return s.length == s.toSet().size
}

fun main() {
  hasUniqueCharacters("abcd") eq true
  hasUniqueCharacters("abcb") eq false
}