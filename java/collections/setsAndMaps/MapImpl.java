package collections.setsAndMaps;

import java.util.*;

public class MapImpl {
    static void main() {
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "Aditya");
        map.put(102, "Rohit");
        System.out.println(map.put(103, "Rohan"));

        System.out.println(map.size());
        System.out.println(map.isEmpty());

        System.out.println(map.containsKey(101)); //O(1)
        System.out.println(map.containsValue("Sneha")); // O(N) bcz of LL traversal

        System.out.println(map.get(101));

        System.out.println(map.put(103, "Sneha")) ;//updates 103 key but returns already existing value
        System.out.println(map.get(103)); //here Sneha will be returned

        System.out.println("here : "+ map.remove(101)); //Aditya will be printed

        HashMap<Integer, String> map2 = new HashMap<>();
        map.putAll(map2);

        Set<Integer> s = map.keySet(); // unique values of keys are there
        System.out.println(s);

        Collection<String> values = map.values(); // not a set
        System.out.println(values);

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        System.out.println(entrySet);

        System.out.println(map.getOrDefault(105, "unknown"));

        System.out.println(map.putIfAbsent(103, "Aman"));

        System.out.println(map);

        System.out.println(map.putIfAbsent(101, "Aditya"));

        System.out.println(map);

        map.remove(101, "Aditya");

        System.out.println(map);

        map.remove(103, "Aman");

        System.out.println(map);

        map.replace(103, "Aman");

        System.out.println(map);

        map.replace(105, "Siya");

        System.out.println(map);

        map.replace(102, "Rohit", "Siya");

        System.out.println(map);

        Map<Integer, String> map3 = Map.of(
            101, "Aman", 102, "Sneha", 103, "Siya"
        );

        System.out.println(map3);

        // map3.putIfAbsent(104, "Siya"); not alloweds

        System.out.println(map3);

    }
}
