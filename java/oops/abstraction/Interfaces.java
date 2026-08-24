package oops.abstraction;

interface Car {
    default void start() {
        System.out.println("Car started");
    }
    abstract void accelerate();

    abstract void brake();
}

class FuelCar extends Car {

    @Override
    void accelerate() {
        System.out.println("Fuel car is accelerating");
    }

    @Override
    void brake() {
        System.out.println("Applied brakes to fuel car");
    }
}

class ElectricCar extends Car {

    @Override
    void accelerate() {
        System.out.println("Electric car is accelerating");
    }

    @Override
    void brake() {
        System.out.println("Applied brakes to electric car");
    }
}
public class InterfaceClass {
    static void main() {

    }
}
