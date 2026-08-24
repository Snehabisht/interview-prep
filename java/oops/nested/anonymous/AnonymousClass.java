package oops.nested.anonymous;

class Person {
    void introduce() {
        System.out.println("Hi, I am a person");
    }
}

public class AnonymousClass {
    // psvma
    static void main(String[] args) {
        Person p = new Person() {
            @Override
            void introduce() {
                System.out.println("Hi, I am a guest");
            }

            void greet() {
                System.out.println("Hello");
            }
        };
        p.introduce();
        // p.greet(); -> not allowed
    }
}
