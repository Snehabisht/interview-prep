package oops.IO;

import java.util.Scanner;

public class ScannerClass {

    static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); //reads till space
        String s2 = sc.nextLine(); //reads till enter
        System.out.println(s);
        System.out.println(s2);
        boolean b = sc.nextBoolean();
        char c = (char) sc.nextByte();
        System.out.println("sneha");
    }

}
