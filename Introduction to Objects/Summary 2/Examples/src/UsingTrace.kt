// Testing/UsingTrace.kt
import atomictest.*

fun main() {
  println("Hello,")
  println(47)
  println("World!")
  println eq """
    Hello,
    47
    World!
  """
}