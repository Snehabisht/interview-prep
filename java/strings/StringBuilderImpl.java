package strings;

public class StringBuilderImpl {
    static void main() {
        // StringBuilder sb = new StringBuilder(100); capacity

        StringBuilder sb = new StringBuilder();

        sb.append("Sneha");
        sb.append(" Bisht");

        System.out.println(sb);

        sb.insert(2, 'p'); //at 2nd index insert 'o', can even have digit or string

        sb.delete(2, 4); //deletes [2, 4)
        System.out.println(sb);

        sb.deleteCharAt(4);
        System.out.println(sb); // space gone

        sb.replace(0, 4, "sneha");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        System.out.println(sb.charAt(4));

        sb.setCharAt(0, 'p');
        System.out.println(sb);

        System.out.println(sb.length());
        System.out.println(sb.capacity());

        sb.ensureCapacity(100); //minimum capacity

        System.out.println(sb.capacity());

        sb.trimToSize(); //utne hi capacity me le aao jitna consume ho raha hai

        System.out.println(sb.capacity());

    }
}
