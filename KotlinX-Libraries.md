## KotlinX Libraries

They complement the basic functionality provided by Kotlin’s standard library.
Maintained by the Kotlin team.

As of 2023 they are the following

- kotlinx.coroutines ----------------> stable
- kotlinx.serialization -------------> stable
- kotlinx.datetime ---------------> alpha
- kotlinx.collections.immutable --> alpha
- kotlinx.atomicfu -----------------> beta
- kotlinx.kover ------------------> alpha
- kotlinx.lincheck ---------------> alpha
- kotlinx.benchmark --------------> alpha

### kotlinx.serialization

It doesn't use reflection (better performance), and works as a compiler plugin.
It supports polymorphism.
For open hierarchies, you can register the hierarchy.

```kotlin
sealed interface ChatEvent {
    val userName: String
}

@Serializable
data class MessageEvent(
    val username: String,
    val message: String
): ChatEvent

val event = MessageEvent("Alice", "Hi")

val string = Json.encodeToString(event)
println(string)   // {"username":"Alice", .....}

val result = Json.decodeFromString<MessageEvent>(string)
println(string)   // MessageEvent(username=Alice, .....)
```







