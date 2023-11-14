// Constructors/Task1.kt
package constructorsExercise1

class Floating(val d: Double) {
    override fun toString() = d.toString()
}

fun main() {
    val float2 = Floating(2.2)
    println(float2)
}