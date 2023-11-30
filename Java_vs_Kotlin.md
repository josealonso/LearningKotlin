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
}
```

``` Java
public boolean needsProcessing(File file, LongPredicate predicateFunction) throws IOException {
    return predicateFunction.test(file.length());
}
```
