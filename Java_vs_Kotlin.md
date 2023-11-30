## Java versus Kotlin

### Lightweight syntax

** Java **
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


** Kotlin **
val person = Person(name = "John", age = 30)

CONCLUSION: ** Named arguments ** make builders obsolete.
------------------------------------------------------------------------------






