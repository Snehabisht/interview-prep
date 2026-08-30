package collections.list;

import java.util.*;

public class ListImpl {
    static void main() {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        // 2 3 4

        System.out.println(l.get(2));

        l.set(2, 8);
        // 2 3 8

        System.out.println(l);

        l.addAll(1, List.of(1, 6, 9));
        // 2 1 6 9 3 8

        System.out.println(l);

        ListIterator<Integer> it = l.listIterator(5); // is set at before index 5

        System.out.println("Printing backwards");

        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
        // 3 6 9 1 2

        System.out.println(l);

        it = l.listIterator(5);
        while(it.hasPrevious()){
            System.out.println(it.previousIndex());
            it.previous();
        }
        // 4 3 2 1 0

        System.out.println(l);

        List<Integer> l2 = List.of(2, 3, 4, 5);
        System.out.println(l2);

        // l2.add(3); not allowed
        System.out.println(l2);

        List<Integer> l3 = List.copyOf(l);
        System.out.println(l3);

        List<Integer> l4 = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

    }
}
