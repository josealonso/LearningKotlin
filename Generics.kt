// Generic types are very similar to those from the Java language, but the Kotlin language creators tried to 
// make them a little bit more intuitive and understandable by introducing special keywords like out and in.

class ParameterizedClass<A>(private val value: A) {
    fun getValue(): A {
        return value
    }
}

val parameterizedClass = ParameterizedClass<String>("string-value")
val res = parameterizedClass.getValue()
assertTrue(res is String)

// Kotlin can infer the generic type from the parameter type so we can omit that when using the constructor:
val parameterizedClass = ParameterizedClass("string-value")
val res = parameterizedClass.getValue()
assertTrue(res is String)
// ========================================================================= //

// We have a producer class that will be producing a result of some type T. 
class ParameterizedProducer<T>(private val value: T) {
    fun get(): T {
        return value
    }
}

// Sometimes we want to assign that produced value to a reference that is of a supertype of the type T.
val parameterizedProducer = ParameterizedProducer("string")
val ref: ParameterizedProducer<Any> = parameterizedProducer
assertTrue(ref is ParameterizedProducer<Any>)
// To achieve that using Kotlin, we need to use the out keyword on the generic type
class ParameterizedProducer<out T>(private val value: T) ......

// Sometimes we want to assign that produced value to a reference that is of a subtype of the type T.
val parameterizedConsumer = ParameterizedConsumer<Number>()
val ref: ParameterizedConsumer<Double> = parameterizedConsumer
assertTrue(ref is ParameterizedConsumer<Double>)
// To achieve that using Kotlin, we need to use the in keyword on the generic type
class ParameterizedProducer<in T>(private val value: T) ......
// ========================================================================= //

// Star Projections

// It is used when we do not care about the specific type of value.
fun printArray(array: Array<*>) { 
    array.forEach { println(it) }
}

val array = arrayOf(1,2,3) 
printArray(array)
// When using the star projection reference type, we can read values from it, but we cannot write them because it will cause a compilation error.

// ========================================================================= //

// Multiple Upper Bounds in Generic Constraints
fun <T> sort(xs: List<T>) where T : CharSequence, T : Comparable<T> { 
    // The parameter T must implement the CharSequence and Comparable interfaces at the same time
    ........
}















