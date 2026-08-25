package strings;

public class StringsImpl {

    static void main() {
        String s1 = "";
        System.out.println(s1.isEmpty());
        System.out.println(s1.isBlank());
        System.out.println();

        String s2 = " ";
        System.out.println(s2.isEmpty());
        System.out.println(s2.isBlank());
        System.out.println();

        String s3 = new String("");
        System.out.println(s3.isEmpty());
        System.out.println(s3.isBlank());
        System.out.println();

        String s4 = new String(" ");
        System.out.println(s4.isEmpty());
        System.out.println(s4.isBlank());
        System.out.println();

        String s5 = new String();
        System.out.println(s5.isEmpty());
        System.out.println(s5.isBlank());
        System.out.println();

        String s6 = "sneha";
        System.out.println(s6.contains("ea"));
        System.out.println(s6.contains("ea"));

        System.out.println(s6.substring(0,3));


        String s7 = "        sneha       bisht             ";
        System.out.println(s7.trim());
        s7 = "        sneha       bisht             ";
        System.out.println(s7.strip());

        String s8 = "Sneha, Bisht, Google";
        String[] arr = s8.split(","); //splits till first delimiter ie., , so <space>Bisht will come

        for(String s:  arr){
            System.out.println(s);
        }
        System.out.println();

        System.out.println(String.join("-", "a", "b", "c"));

        String s9 = new String(String.valueOf(Object.class));
        System.out.println(s9);

        String s10 = "Sneha";
        byte[] arr2 = s10.getBytes();
        for (byte a: arr2){
            System.out.print(a+", ");
        }
        System.out.println();

        String s11 = new String("Sneha");
        String s12 = s11.intern();
        System.out.println(s11 == s12);


        System.out.println(String.format("Hello %s, your age is %s", s11, "28"));

    }
}
