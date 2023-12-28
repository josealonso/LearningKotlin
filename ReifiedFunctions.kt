// Kotlin and Java erase generic type information at compile time. That is, the generic type parameters, such as <T>, are not present in the bytecode.
// As a consequence, the Java code is not easy to read:

// String json = objectMapper.readValue(data, String.class);
// Map<String, String> json = objectMapper.readValue(data, new TypeReference<Map<String, String>>() {});

// We don’t have access to the class metadata of a generic parameter T 
// or technically speaking, T is not reified at runtime.
// Kotlin solves this issue with Inline Reified Functions.

inline fun <reified T> ObjectMapper.readValue(data: ByteArray): T =
  readValue(data, object : TypeReference<T>() {})

fun main() {
  // val json = objectMapper.readValue<String>(data)
  // val json: String = objectMapper.readValue<String>(data)
  val json: Map<String, String> = objectMapper.readValue<String>(data)
}
