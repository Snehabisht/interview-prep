package collections;


import java.util.ArrayDeque;

public class StackAndQueueImpl {
    static void main() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(2);
        queue.offer(4);
        System.out.println(queue);

        System.out.println(queue.peek());
    }
}
