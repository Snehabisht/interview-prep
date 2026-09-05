package interfaces;

interface Car {
    public static final String ENGINE = "BlackRox";
    void drive();

}

abstract class Thar implements Car {

//    @Override
//    public void drive() {
//        System.out.println("Thar is driving");
//    }
}

class BlackThar implements Car { //or extends Thar

    @Override
    public void drive() {
        System.out.println("Black Thar is driving");
    }
}


public class Interfaces {
    static void main() {
        Car car = new BlackThar();
        car.drive();
    }
}
