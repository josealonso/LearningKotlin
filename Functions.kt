// Funcions can be single expressions, in this case "return" is not used
fun greet(name: String): String = "Hello $name"

println(greet("Bob"))

// Default arguments
fun greet(name: String, msg: String = "Hello"): String = "$msg $name"
println(greet("Bob", "Good morning"))
println(greet("Bob"))   // Hello Bob

// Named arguments
// You can mix positional and named arguments
val message = greet(msg = "Good morning", name = "Bob")

// ================================================================
// varargs for a parameter that accepts a variable number of arguments.
fun printSorted(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}

fun main() {
    printSorted(6, 2, 10, 1) // [1, 2, 6, 10]
}

// You can also pass an actual array instance instead of the variable argument list prefixing it with a spread operator *
val numbers = intArrayOf(6, 2, 10, 1)
printSorted(*numbers)

// Note that spread creates an array copy so changes to elements of items parameter do not affect values of the numbers elements:
fun main() {
    val numbers = intArrayOf(6, 2, 10, 1)
    printSorted(*numbers)        // [1, 2, 6, 10]
    println(a.contentToString()) // [6, 2, 10, 1]
}
// The copying, however, is shallow. If array elements are themselves references, copying those references lead to sharing the data between the function and its caller.

// ================================================================

// As opposed to Java, the unreachable code in Kotlin is not a compile-time error.
// The compiler will, however, report a warning.

// Unlike Java’s method parameters which are mutable by default and must be marked with the final modifier to forbid further changes in the method body, 
// Kotlin parameters are immutable. In other words, changing the parameter value inside a function body is a compilation error:
fun increment(n: Int): Int = n++ // Error: can’t change immutable variable
// Note also that marking the parameter with the val or var keyword is forbidden.

// If you skip the return type in your function definition, the Kotlin compiler automatically assumes that you’re declaring a Unit function. 

// Trailing commas
// Since Kotlin 1.4, it’s possible to leave trailing commas when listing elements such as arguments in a function call or parameters in a function header:
fun volume(length: Int, width: Int, height: Int, ) = length*width*height
val numbers = intArrayOf(1, 2, 3, 4, 5,)

// ================================================================
// Function scope and visibility

// Kotlin functions can be broken down into three categories depending on where they’re defined:
// 1.- Top-level functions are declared directly in a file.
// They are public by default. Other modifiers: private, internal.
// 2.- Member functions are declared in some type.
// 3.- Local functions are declared inside another function.




  
