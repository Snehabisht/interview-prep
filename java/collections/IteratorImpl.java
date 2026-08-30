package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NameContainer implements Iterable<String>{
    private final String[] names;
    private final int size;


    NameContainer(String[] names){
        this.names = names;
        this.size = this.names.length;
    }

    // NameContainerIterator is getting used once, we can create its object directly(anonymous class)
    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public String next() {
                return names[pos++];
            }
        };
    }
}


public class IteratorImpl {
    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            int val = it.next(); //gives and moves to next element
            if(val == 30){
                it.remove(); //not list.remove()
                continue;
            }
            System.out.println(val);
        }


        String[] names = {"Sneha", "Aman", "Siya", "Somya"};
        NameContainer nameContainer = new NameContainer(names);
//        Iterator it = nameContainer.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        // enhanced for loop -> converted to above in JVM
        for (String name : nameContainer){
            System.out.println(name);
        }

        //
    }
}
