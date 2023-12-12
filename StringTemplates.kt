val user = "Alice"
println("Message: ${composeGreeting(user)}")

fun multilineStrings() {
  // useful when you have indentation
  val str = """
  ......
  ......
  """.trimMargin()
}

fun composeGreeting(user: String) = "Hello, $user"
