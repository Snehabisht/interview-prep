package oops.abstraction;

interface ICar {
    default void start() {
        System.out.println("Car started");
    }
    void accelerateCar();

    void brakeCar();
}

class FuelCarImpl implements ICar {

    @Override
    public void accelerateCar() {
        System.out.println("Fuel car is accelerating");
    }

    @Override
    public void brakeCar() {
        System.out.println("Applied brakes to fuel car");
    }
}

class ElectricCarImpl implements ICar {

    @Override
    public void accelerateCar() {
        System.out.println("Electric car is accelerating");
    }

    @Override
    public void brakeCar() {
        System.out.println("Applied brakes to electric car");
    }
}
public class Interfaces {
    static void main() {
        ICar car = new ElectricCarImpl();
        car.start();
        car.accelerateCar();
        car.brakeCar();
    }
}
