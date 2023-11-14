// InKeyword/Task1.kt
package theInKeywordExercise1

fun getAlphabet(): String {
  var alphabet = ""
  for (letter in 'a'..'z') {
    alphabet += letter
  }
  return alphabet
}

fun main() {
  println(getAlphabet())  // abcdefghijklmnopqrstuvwxyz
}