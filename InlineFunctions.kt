// Two main use cases

//  1.- Removing the Overhead of Lambdas
// When using lambdas, the extra memory allocations and extra virtual method call introduce some runtime overhead.
// 

inline fun <T> Collection<T>.each(block: (T) -> Unit) {
    for (e in this) block(e)
}
val numbers = listOf(1, 2, 3, 4, 5)
numbers.each { println(it) }

// Above code is compiled to the following
val numbers = listOf(1, 2, 3, 4, 5)
for (number in numbers)
    println(number)

// we can mark some of the lambdas with the noinline keyword to exclude them from inlining:
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { ... }
    
// Conclusion: When using inline functions, there is no extra object allocation and no extra virtual method calls. 








