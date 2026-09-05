package multithreading;

import static java.lang.Thread.sleep;

public class ProducerConsumerProblem {
    static void main() {
        Box box = new Box();
        Thread t1 = new Thread( ()-> {
            for(int i = 0; i<=20; ++i){
                try {
                    sleep(100);
                    box.producer(10);
                } catch (InterruptedException e) {}
            }
        }
        );
        Thread t2 = new Thread(()-> {
            for(int i = 0; i<=20; ++i){
                try {
                    sleep(100);
                    box.consumer();
                } catch (InterruptedException e) {}
            }
        }
        );
        t1.start();
        t2.start();

    }
}

class Box {
    Integer item;
    Boolean flag = false;

    synchronized void producer(int value) throws InterruptedException {
        while(flag == true){
            wait();
        }
        item = value;
        flag = true;
        System.out.println("Producer produces "+ item);
        notify();
    }

    synchronized void consumer() throws InterruptedException {
        while(flag == false){
            wait();
        }
        System.out.println("Consumer consumes "+ item);
        item = null;
        flag = false;
        notify();
    }
}
