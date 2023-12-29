// TWO main use cases

//  1.- Removing the Overhead of Lambdas
fun <T> Collection<T>.filter(predicate: (T) -> Boolean): Collection<T> = // Omitted
// compiles into 
public static final <T> Collection<T> filter(Collection<T>, kotlin.jvm.functions.Function1<T, Boolean>);

// Every time we declare a higher-order function, at least one instance of those special Function* types will be created.
// Why does Kotlin do this instead of, say, using invokedynamic like how Java 8 does with lambdas? 
// Because Kotlin goes for Java 6 compatibility, and invokedynamic isn’t available until Java 7.

fun main() {
    sampleCollection.filter { it == 1 }
}

// Something similar to the following Java code will be produced to wrap the lambda code:
filter(sampleCollection, new Function1<Integer, Boolean>() {
  @Override
  public Boolean invoke(Integer param) {
    return param == 1;
  }
});
// In order to actually perform the operation encapsulated in a Kotlin lambda, 
// the higher-order function – filter in this case – will need to call the special method named invoke on the new instance. 
// The result is more overhead due to the extra call.

// When using inline functions, the compiler inlines the function body. That is, it substitutes the body directly into places where the function gets called.
inline fun <T> Collection<T>.each(block: (T) -> Unit) {
    for (e in this) block(e)
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.each { println(it) }
}

// Above code is compiled to the following
val numbers = listOf(1, 2, 3, 4, 5)
for (number in numbers)
    println(number)

// we can mark some of the lambdas with the noinline keyword to exclude them from inlining:
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { ... }
    
// Conclusion: When using inline functions, there is no extra object allocation and no extra virtual method calls. 








