package collections.setsAndMaps;

import java.util.*;

public class TreeMapImpl {
    static void main() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(101, "Aditya");
        map.put(102, "Rohit");
        map.put(103, "Rohan");

        // TreeMap<Integer, Integer> map2 = new TreeMap<>(Map.of(2,5,6,8));


        // sorted map interface
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());

        System.out.println(map.headMap(103)); //<103

        System.out.println(map.tailMap(102)); //>=102, 102 inclusive

        System.out.println(map.subMap(101, 103)); // >=101 and <103

        // navigable map interface
        System.out.println(map.lowerEntry(102)); //largest no <102 or lowerKey

        System.out.println(map.floorEntry(102)); //largest no <=102

        System.out.println(map.higherEntry(102)); //smallest no >102

        System.out.println(map.ceilingEntry(103)); //smallest no >=103

        System.out.println(map.pollFirstEntry());  //returns smallest as well as remove from the map

        System.out.println(map);

        System.out.println(map.pollLastEntry());  //returns largest as well as remove from the map

        System.out.println(map);

        System.out.println(map.descendingMap()); // descending order

    }
}
