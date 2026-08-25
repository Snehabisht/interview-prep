package interfaces;

interface Animal {
    void eat();
}

interface Dog extends Animal {
    @Override
    default void eat(){
        System.out.println("Dog eats");
    }

    void barks();
}

class StreetDog implements Dog {

    @Override
    public void barks() {
        System.out.println("StreetDog barks");
    }
}

public class InterfaceInheritance {
    static void main() {
        Dog dog = new StreetDog();
        dog.eat();
        dog.barks();
    }
}
