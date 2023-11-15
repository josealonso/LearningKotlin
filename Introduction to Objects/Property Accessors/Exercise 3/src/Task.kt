// PropertyAccessors/Task3.kt
package propertyAccessorsExercise3

import atomictest.eq
import lists.getList

class MessageStorage {
    private var _messages = mutableListOf<String>()
        get() {
            return field
        }

    val messages: List<String>
        get() {
            return _messages
        }

    fun addMessage(message: String) = _messages.add(message)
}

fun main() {
    val messageStorage = MessageStorage()
    messageStorage.addMessage("first")
    messageStorage.addMessage("second")
    messageStorage.messages eq listOf("first", "second")
    // doesn't compile:
//  messageStorage.messages.remove("first")
}