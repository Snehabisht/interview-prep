package multithreading.exectorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class VirtualThreadImpl {
    static void main() {
        Thread t1 = Thread.startVirtualThread(
                () -> {
                    // not getName(), kuch nahi print hoga
                    System.out.println(Thread.currentThread());
                }
        );
        // no need for .start(), else IllegalThreadStateException
        // t1.start();

        try {
            t1.join();
        } catch (Exception _) {}

        // another way
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 5; i++) {
            executor.submit(
                    () -> {
                        System.out.println("Task executed by "+ Thread.currentThread());
                    }
            );
        }

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
        executor.shutdown(); //not an issue
    }
}
