// Summary2/Task3.kt
package summaryIIExercise3

import atomictest.*

class FixedSizeHolder(private val limit: Int) {
    private val list = mutableListOf<Any>()
    val size: Int
        get() {
            return list.size
        }
    val full: Boolean
        get() {
            return list.size == limit
        }

    fun add(elem: Any) {
        if (full) throw IllegalStateException("IllegalStateException: The container is full")
//        list.add(elem)
        list += elem
    }
}

fun main() {
    val holder = FixedSizeHolder(2)
    holder.add("What is the answer?")
    holder.add(42)
    holder.full eq true
    holder.size eq 2
    capture {
        holder.add("!!!")
    } eq "IllegalStateException: The container is full"
}