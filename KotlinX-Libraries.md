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

### Kotlinx.Serialization

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

### Kotlinx.Coroutines

- flow (cold flow)
- StateFlow (hot flow) -----> represents changing state
- SharedFlow (hot flow) ----> represents flow of events
TBD

### Kotlinx.DateTime

Main types: LocalDateTime, LocalDate, LocalTime, Instant, Clock, TimeZone.

### Kotlinx.Collections.Immutable

A List can be a MutableList, that might cause issues.
This extended collection provides two main types: **PersistentList** and **ImmutableList**.
Jetpack Compose "acknowledges" immutable types from this library.
Compose can skip recomposition with immutable parameters.







