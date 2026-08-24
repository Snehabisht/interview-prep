package oops.abstraction;

abstract class Car {
    void start() {
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

public class AbstractClass {
    static void main() {
        // Car car = new Car(); not allowed
        Car car = new FuelCar();
        car.start();
        car.accelerate();
        car.brake();
    }
}
