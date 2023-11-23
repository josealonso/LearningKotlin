fun main() {
    val coordA = Coordinates(2, 3)
    val coordB = Coordinates(4, 0)
    println(coordA + coordB)
    println(coordA * 3)
}

data class Coordinates(val x: Int, val y: Int)

operator fun Coordinates.plus(other: Coordinates) = 
    Coordinates(this.x + other.x, this.y + other.y)   // "this" is optional

operator fun Coordinates.times(num: Int) = 
    Coordinates(x * num, y * num)    // "this" is optional
