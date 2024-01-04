/*
  The Kotlin standard library contains several functions whose sole purpose is to execute a block of code 
  within the context of an object. When you call such a function on an object with a lambda expression provided, it forms a temporary scope. In this scope, you can access the object without its name. 
  Such functions are called scope functions. There are five of them: let, run, with, apply, and also.
  These functions all perform a similar action: execute a block of code on an object. 
  What's different is how this object becomes available inside the block and what the result of the whole expression is.
*/

// 1.- let: executing a lambda on non-nullable objects or introducing an expression as a variable in local scope.
data class Person(val name: String, var age: Int = 0) {
    fun incrementAge(years: Int) {
      this.age = age + years  
    } 
}

fun main() {
    // Without let
    val alice = Person("Alice", 32)
    println(alice)
    alice.incrementAge(3)
    println(alice)

    // With let
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

// 2.- with: It is used for calling functions on the context object when you don't need to use the returned result. 
//     In code, with can be read as "with this object, do the following."

    val numbers2 = mutableListOf("one", "two", "three")
    with(numbers2) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }    

    // "with" can also be used to introduce a helper object whose properties or functions are used for calculating a value.
    val firstAndLast = with(numbers2) {
        "The first element is ${first()}," +
        " the last element is ${last()}"
    }
    println(firstAndLast)   // The first element is one, the last element is three

// 3.- run: It does the same as "with" but it is implemented as an extension function. So like let, 
//     you can call it on the context object using dot notation.
//     It is useful when your lambda both initializes objects and computes the return value.

    val service = MultiportService("https://mysite.com", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    // the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }

// 4.- apply: It is used for code blocks that don't return a value and that mainly operate on the members of the receiver object. 
//     The most common use case for apply is for object configuration. Such calls can be read as 
//     "apply the following assignments to the object."
//     It is useful when your lambda both initializes objects and computes the return value.

    val bob = Person("Bob").apply {
        age = 32
    }
    println(bob)
    
}








