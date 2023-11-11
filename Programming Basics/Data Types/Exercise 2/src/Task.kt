// DataTypes/Task2.kt
package dataTypesExercise2

fun main() {
  val int: Int = 10
  val double: Double = 1.1
  val boolean: Boolean = false
  val string: String = "abc"
  val character: Char = 'a'

  // Can be combined:
  val combined1 = int + double
  val combined2 = string + character
  val combined3 = string + int
  val combined4 = string + double
  val combined5 = string + boolean
  val combined6 = character + int

//  println("$combined2 $combined3 $combined4 $combined5")

  println("The type that can be combined " +
    "with every other type using '+':")
  println("String")

  // Can't be combined:
//  println("int + boolean")
}