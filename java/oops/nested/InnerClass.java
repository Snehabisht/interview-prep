package oops.nested;

class OuterClass {
    int x = 10;
    class InnerClass {
        int x = 20;
        static int y = 7;
        void fun() {
            System.out.println("Hello from inner class");
            System.out.println(x); //20
            System.out.println(OuterClass.this.x); //10;
        }
        static void fun2() {
            System.out.println("Hello from static method inside inner class");
            System.out.println(y); //7
        }
    }
}
public class InnerClass {
    static void main() {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.fun();
        // OuterClass.InnerClass inner = new OuterClass().new InnerClass(); -> if we dont need outer class object
        inner.fun2();
        OuterClass.InnerClass.fun2();
    }
}
