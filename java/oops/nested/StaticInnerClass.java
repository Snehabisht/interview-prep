package oops.nested;

class Outer {
    int x;
    static class Inner {
        Outer outer;
        Inner(Outer outer){
            this.outer = outer;
        }
//        void fun(Outer outer) {
//            System.out.println("Hello");
//            System.out.println(outer.x);
//        }

        void fun() {
            System.out.println("Hello from static inner class");
            System.out.println(outer.x);
        }
    }
}
class BankAccount {

    //logical grouping, only objects of the bankAccount class can access
    private static class InterestCalculator {
        static double calculateYearly(double principal, double rate){
            return principal * rate;
        }

        static double calculateMonthly(double principal, double rate){
            return principal * rate;
        }
    }

    public double computeInterest(double principal){
        return InterestCalculator.calculateYearly(principal, 0.02);
    }
}
public class StaticInnerClass {
    static void main() {
        Outer outer = new Outer();
//        Outer.Inner inner = new Outer.Inner(); //no need to outer class object
//        inner.fun(outer);
        Outer.Inner inner = new Outer.Inner(outer); //no need to outer class object
        inner.fun();
    }
}
