package generics;

import oops.abstraction.Interfaces;

import java.util.List;

class Animal { }
class Dog extends Animal{}
interface Swimmable {
    void swim();
}
class Fish extends Animal implements Swimmable {

    @Override
    public void swim() {
        System.out.println("Fish swims");
    }
}

class GenericAnimal<T extends Animal & Swimmable> {

}

class Box<T> { // type parameter -> parameter of class
    private T value; //T is a placeholder

    Box (T value){
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    void setValue(T value) {
        this.value = value;
    }
}

//T is atleast Number or its subtype
class BoundedGenerics<T extends Number> {
    T value;

    public void printDouble() {
        System.out.println(this.value.doubleValue());
    }
}

public class GenericsImpl {
    static void main() {
        Box<Integer> b = new Box<> (2);
        b.setValue(5);
        System.out.println(b.getValue());
        printData(getData("abc")); //type inference
    }

    static <T> void printData(T data) {
        System.out.println(data);
    }

    static <T> T getData(T data) {
        return data;
    }

    GenericAnimal<Fish> genericAnimal = new GenericAnimal<>(); //no Dog

}
