package collections.setsAndMaps;

import java.util.*;

public class TreeSetImpl {
    static void main() {
        TreeSet<Integer> set = new TreeSet<>();

        // Set<Integer> set2 = new TreeSet<>(List.of(2,5,6,8));

        set.add(80);
        set.add(23);
        set.add(10);
        set.add(90);
        set.add(50);

        // sorted set interface
        System.out.println(set.first());
        System.out.println(set.last());

        System.out.println(set.headSet(80)); //<80

        System.out.println(set.tailSet(80)); //>=80, 80 inclusive

        System.out.println(set.subSet(23, 80)); // >=23 and <80

        // navigable set interface
        System.out.println(set.lower(80)); //largest no <80

        System.out.println(set.floor(80)); //largest no <=80


        System.out.println(set.higher(80)); //smallest no >80

        System.out.println(set.ceiling(80)); //smallest no >=80

        System.out.println(set.pollFirst());  //returns smallest as well as remove from the set

        System.out.println(set);

        System.out.println(set.pollLast());  //returns largest as well as remove from the set

        System.out.println(set);

       // System.out.println(set.descendingSet()); // descending order

        Iterator<Integer> it = set.descendingIterator();
        while (it.hasNext()){
            System.out.print(it.next()+ ", ");
        }
        System.out.println();

        System.out.println(set.headSet(80, true)); //now 80 will be included, <=80

        System.out.println(set.tailSet(80, true)); //now 80 will be included, >=80

        System.out.println(set.subSet(23, true, 80, true)); //now 80 will be included

    }
}
