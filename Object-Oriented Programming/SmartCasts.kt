
// Argument matching and auto casting

// Java
// public static void process(Object input) {
//   if(input instanceOf String) { 
//     System.out.println(
//             "got a string of length " + ((String) input.length);
//  } else {
//    ..
//  }
//}

fun process(input: Any): String {
  val result = when(input) {
    1 -> "one"
    in 13..19 -> "teen"
    is String -> "got a string of length ${input.length}"
    else -> "whatever"
  }
  return result
}

fun main() {
  println(process(1))
  println(process(14))
  println(process("hello"))
}

