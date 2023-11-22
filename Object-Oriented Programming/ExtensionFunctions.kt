// Implement the extension functions Int.r() and Pair.r() and make them convert Int and Pair to a RationalNumber.
// Pair is a class defined in the standard library:
// 
// data class Pair<out A, out B>(
//     val first: A,
//     val second: B
// )
// 
// In the case of Int, the denominator is 1. 

fun Int.r(): RationalNumber = Pair<Int, Int>(this, 1).r()

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)
