// Funtions parameters are always immutable

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

// varargs for several parameters. It's similar in Java.
// vararg is a keyword in Kotlin
