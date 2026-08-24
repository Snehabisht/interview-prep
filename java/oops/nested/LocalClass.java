package oops.nested;

class OuterClassLocal {
    static int a = 10;

    void fun() {
        int x;// = 10;
        x = 10;
        // x++; //not allowed
        // a=9; or a+=1;//allowed
        class Local {
            void sayHello() {
                System.out.println(x);
                System.out.println("Hello from local class");
            }
        }
        Local l = new Local();
        l.sayHello();
    }
}

public class LocalClass {
    static void main() {
        OuterClassLocal outerClassLocal = new OuterClassLocal();
        outerClassLocal.fun();
    }

}
