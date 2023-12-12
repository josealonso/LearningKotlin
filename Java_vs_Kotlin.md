## Java versus Kotlin

### Obvious differences

- Semicolon is optional.
- Strong type inference.
- **val** versus **var**.
- String templates.
- Multiline strings
- Expressions over statements.

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


### Pattern matching

#### When Expression with argument 

Modern Java has Scala-like pattern matching, but nothing is returned, since it is not an expression.

``` Kotlin
fun wildMatch(p: Any?): String = when(p) {
    is Int    -> "${p * 2}"
    is Long?  -> "null or Long"
    in 1..10  -> "Value is in 1-10 range"
    else -> "The default"
  }
}
```

### Using Kotlin from Java

#### Accessing properties

``` kotlin
class Person(var name: String, val age: Int, var isEmployed: Boolean)
```

A Java code accessing the Person properties would look like this:

``` java
public class Main {
    public static void main(String[] args) {
        Person person = new Person(“John”, 25, false);
        person.setName(“Alice”);
        System.out.println(person.getName()); // Alice
        person.setEmployed(true);
        System.out.println(person.isEmployed()); // true
    }
}
```

A property can be exposed to Java clients by using the @JvmField annotation. 

``` kotlin
class Person(@JvmField var name: String, @JvmField val age: Int)
```

``` java
public class Main {

    public static void main(String[] args) {
        Person person = new Person(“John”, 25);
        System.out.println(person.age);  // 25
        person.name = “Harry”;
        System.out.println(person.name); // Harry
    }
}
```

@JvmField cannot be used if 
- the property has non-trivial accessors.
- the property is open or abstract.
- the property is a *lateinit* one.

When applied to a property of some named object, @JvmField behaves a little differently generating a static field instead of an instance one.

``` kotlin
object Application {
    @JvmField
    val name = “My Application”
}
``` 

``` java
public class Main {
    public static void main(String[] args) {
        System.out.println(Application.name);
    }
}
```

The same also goes for properties with the const modifier:

``` kotlin
object Application {
    const val name = “My Application”
}
```

A **lateinit** property can be accessed both directly and with accessor calls:

``` kotlin
class Person(val firstName: String, val familyName: String) {
    lateinit var fullName: String

    fun init() {
        fullName = “$firstName $familyName”
    }
}
``` 

```  java
public class Main {
   public static void main(String[] args) {
        Person person = newPerson(“John”, “Doe”);
        person.init();

        // direct field access
        System.out.println(person.fullName);      // John Doe

        // accessor call
        System.out.println(person.getFullName()); // John Doe
    }
}
``` 

In objects, **lateinit** generates a static field similar to the @JvmField annotation.


#### File facades and top-level declarations

The Kotlin compiler puts top-level functions and properties into an automatically generated class which is called a *file facade*.

```  kotlin
// util.kt

class Person(val firstName: String, val familyName: String)
val Person.fullName
get() = “$firstName $familyName”

fun readPerson(): Person? {
    val fullName = readLine() ?: return null
    val p = fullName.indexOf(‘ ‘)
    return if (p >= 0) {
        Person(fullName.substring(0, p), fullName.substring(p + 1))
    } else {
        Person(fullName, “”)
    }
}
```

Will produce the following facade class:

```  java
public class UtilKt {

    @NotNull
    public static String getFullName(@NotNull Person person) {...}

    @Nullable
    public static Person readPerson() {...}
}
```

The file-level @JvmName annotation allows to change the generated facade name:

``` kotlin
@file:JvmName(“MyUtils”)

сlass Person(val firstName: String, val familyName: String)
val Person.fullName
get() = “$firstName $familyName”
```

Now, its Java usages will need to use the specified MyUtils name:

``` java
public class Main {
    public static void main(String[] args) {
        Person person = new Person(“John”, “Doe”);
        System.out.println(MyUtils.getFullName(person));
    }
}
```

The file-level @JvmMultifileClass annotation allows to merge top-level declarations from multiple files into a single class.

Note that facade classes are not available to the Kotlin code and are only usable by other JVM clients.


#### Objects and static members

On JVM, Kotlin object declarations are compiled into ordinary classes with the static INSTANCE field:

``` kotlin
object Application {
    val name = “My Application”
    fun exit() { }
}
```

``` java
public class Main {
    public static void main(String[] args) {
        System.out.println(Application.INSTANCE.name);
        Application.INSTANCE.exit;
    }
}
```

The @JvmStatic annotation makes object functions or property accessors available as *static methods*.

#### Changing the exposed declaration name

The @JvmName annotation allows to change the name of the corresponding JVM methods, property accessors and the properties themselves.

``` kotlin
class Person(@set:JvmName(“changeName”) var name: String, val age: Int)
``` 

``` java
public class Main {
    public static void main(String[] args) {
        Person person = newPerson(“John”, 25);
        person.changeName(“Harry”);
        System.out.println(person.getName());
    }
}
``` 














