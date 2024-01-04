/*
  The Kotlin standard library contains several functions whose sole purpose is to execute a block of code 
  within the context of an object. When you call such a function on an object with a lambda expression provided, it forms a temporary scope. In this scope, you can access the object without its name. 
  Such functions are called scope functions. There are five of them: let, run, with, apply, and also.
  These functions all perform a similar action: execute a block of code on an object. 
  What's different is how this object becomes available inside the block and what the result of the whole expression is.
*/

// 1.- let: executing a lambda on non-nullable objects or introducing an expression as a variable in local scope.
data class Person(val name: String, var age: Int) {
    fun incrementAge(years: Int) {
      this.age = age + years  
    } 
}

// Without let
fun main() {
    val alice = Person("Alice", 32)
    println(alice)
    alice.incrementAge(3)
    println(alice)
}

// With let
fun main() {
    Person("Alice", 32).let {
        println(it)
        it.incrementAge(3)
        println(it)
    }
    // Other example
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)  // 5, 4, 4

    // let is often used to execute a code block containing non-null values. 
    // To perform actions on a non-null object, use the safe call operator ?. on it and call let with the actions in its lambda.

    val str: String? = "Hello"   
    // Without let
    if (str != null) {
        println("let() called on $str")        
        str.length
    }

    // With let
    //processNonNullString(str)       // compilation error: str can be null
    val length = str?.let { 
        println("let() called on $it")        
        it.length
    }
}

