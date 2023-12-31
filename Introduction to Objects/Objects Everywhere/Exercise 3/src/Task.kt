// ObjectsEverywhere/Task3.kt
package objectsEverywhereExercise3

fun isPalindrome(s: String): Boolean =
  s.reversed() == s

fun isPalIgnoreCase(s: String): Boolean =
  isPalindrome(s.lowercase())

fun isPalIgnoreSpecial(s: String): Boolean {
  var str = ""
  for (ch in s) {
    if (ch in 'a'..'z' || ch in 'A'..'Z') str += ch
  }
  return isPalIgnoreCase(str)
}

fun main() {
  println(isPalIgnoreSpecial("Was It A Rat I Saw? ..."))  // true
}