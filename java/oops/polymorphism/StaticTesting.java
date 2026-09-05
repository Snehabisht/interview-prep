package oops.polymorphism;

class A {
    int a = 10;
    static void fun() {
        System.out.println("Hello");
    }
    final void greet(){
        System.out.println("namaste");
    }

    private void privateFun() {
        System.out.println("I am private fun of base class");
    }
}

class B extends A {
    int a = 20;
    static void fun() {
        System.out.println("Bye");
    }
    // void greet(){} cannot override final variables

    //different function, privateFun not inherited as it is private
    private void privateFun() {
        System.out.println("I am private fun of child class");
    }
}

public class StaticTesting {
    static void main() {
        A a = new B();
        a.fun();
        System.out.println(a.a); //reference variable's(A) member variable value
        // a.privateFun();
    }
}
