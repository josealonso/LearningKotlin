// Declarations
val a = emptyArray<String>()      // Array<String> (zero elements)
val b = arrayOf(“hello”, “world”) // Array<string> (2 elements)
val c = arrayOf(1, 4, 9)          // Array<Integer> (3 elements)

// A more flexible one
val squares = Array(4) { (it + 1)*(it + 1) }  // 1, 4, 9, 16

// To avoid the boxing of numbers, Kotlin provides specialized array types such as 
// ByteArray, ShortArray, IntArray, LongArray, FloatArray, DoubleArray, CharArray 
val squares = IntArray(4) { (it + 1)*(it + 1) }

// If you want to create a separate array, use the copyOf() function which can also produce an array of different sizes if necessary
val numbers = squares.copyOf()
squares.copyOf(2) // truncated: 1, 4
squares.copyOf(5) // padded with zeros: 1, 4, 9, 16, 0
//  =========================================================
// In Java, you can assign an array of a subtype to an array of its super type. 
// Since arrays are mutable, this can lead to problems at runtime:
Object[] objects = new String[] { “one”, “two”, “three” };
objects[0] = new Object(); // fails with ArrayStoreException

// For this reason, the Kotlin array type is not considered a subtype of any other array type (apart of itself) and 
// such assignments are prohibited. So even though String is a subtype of Any, Array<String> is not a subtype of Array<Any>:
val strings = arrayOf(“one”, “two”, “three”)
val objects: Array<Any> = strings      // Error

//  =========================================================
// Unlike strings, == and != operators on arrays compare references rather than elements themselves:
intArrayOf(1, 2, 3) == intArrayOf(1, 2, 3) // false

// If you want to compare array content, you should use the contentEquals() function:
intArrayOf(1, 2, 3).contentEquals(intArrayOf(1, 2, 3)) // true


