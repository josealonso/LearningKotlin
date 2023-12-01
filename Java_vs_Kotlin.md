## Java versus Kotlin

### Lightweight syntax

``` Java 
    public class PersonBuilder {
        private String name;
        private int age;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(name, age);
        }
    }

    public static void main(String[] args) {
        final Person person = new PersonBuilder()
                .name("John")
                .age(30)
                .build();
    }
```

``` Kotlin
val person = Person(name = "John", age = 30)
```

CONCLUSION: ** Named arguments ** make builders obsolete.
------------------------------------------------------------------------------

- Type inference
- Semicolon is inferred
Since Java has to be backwards compatible, the code starts to be a bit messy when introducing new features.
But Kotlin is a modern language, hence it does not have to support legacy code.

#### Consistent notation

``` Java
Person person = new Person("John", 30);
final var person = new PersonRecord("John", 30);
```

``` Kotlin
var/val person = Person("John", 30);
```

#### More explicit syntax

``` Java
person1.getName().equals(person2.getName())
```

``` Kotlin
person1.name == person2.name
```

#### Infix notation
Kotlin supports infix notation for operators and infix functions. But only for cerain operators, unlike the abused permissiveness of Scala.

``` Kotlin
val persons = listOf(person1, person2)
persons + person3  // The compiler calls the corresponding operator method plus
```

#### Multiple classes in a file 
Kotlin allows multiple public class/interface declarations in a single file 

``` Kotlin
abstract class Person(val name: String, val age: Int)

class Employee(name: String, age: Int, val employeeId: String) : Person(name, age)  // ":" means "extends" in Java

class Company(val name: String, val employees: List<Employee>)
```

### Functional Programming

#### Functions as first-class citizens
Functions as parameters are easier to read and write:

``` Kotlin
fun processFile(file: File, action: (String) -> String): String {
    val content = file.readText()
    return action(content)
}

// Scala-like functions are possible if there is only one expression

fun processFile(file: File, action: (String) -> String): String = action(file.readText())
```

``` Java
String processFile(file: File, Function<String, String> actionFunction) throws IOException {
    var content = file.readText();
    return actionFunction.apply(content);
}
```

``` Kotlin
fun needsProcessing(file: File, predicate: (Long) -> Boolean): Boolean = predicate.test(file.length())
```

``` Java
public boolean needsProcessing(File file, LongPredicate predicateFunction) throws IOException {
    return predicateFunction.test(file.length());
}
```

Deferred execution or lazy evaluation
``` Kotlin
fun writeToFile(file: File, block: () -> String) {
    if (file.isFile)
        writeStringToFile(file, block())
}
```

``` Java
public void writeToFile(File file, Supplier<String> block) throws IOException {
    if (file.isFile()) 
        writeStringToFile(file, block.get());
}
```

### Null Safety

In Java this is "solved" with the so called *defensive programming*

``` Java
// The root cause of defensive programming is a bad API contract
interface ProductService {
    public Integer getMaxRating(String productName);
}
```

``` Java
class Client {
    public Integer showMaxRating(String productName) {
        try {
            Integer maxRate = productService.getMaxRating(productName);
            if(maxRate != null && maxRate != -1) {
                return maxRate;
            }
        } catch(Exception ex)  { }
        return 0;
    }
}
```

``` Kotlin
/*
 Int? is a type itself
 Int? extends Int
 Any? extends Int?
 Any? extends Any?
*/
// Nullable types makes the API contract explicit
class ProductService {
    fun maxRating(productName: String): Int? =  // Int? = Int | null
        if (found) rating else null
}

class Client {
    fun showMaxRating(productName: String) =
        productService.maxRating(productName) ?: 0
}
```

It is a clever design, because **Optional values are not used**. This avoids having to use wrappers.

``` Kotlin
class Booking(val destination: Destination? = null) 
class Destination(val hotel: Hotel? = null) 
class Hotel(val name: String, val stars: Int = null) 
```

``` Kotlin
val booking = Booking(Destination(Hotel()))
val stars = "*".repeat(booking?.destination?.hotel?.stars ?: 0)  // This line checks if the fields are null

// After checking for not null a type is "smart casted" to its non-null type
// from Booking? to Booking
if(booking != null) {
    println(booking.destination)
}
```

**CONCLUSIONS**

- Nullable types avoid NullPointerException (NPE)
- Models get more expressive, capturing nullability
- Less verbose than Options
- Offers interoperability with Java
- Most loved feature in Kotlin














