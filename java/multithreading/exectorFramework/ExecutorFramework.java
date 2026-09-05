package multithreading.exectorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i<5; ++i){
            int taskId = i;
            executorService.execute(
                    () ->
                        System.out.println("Task "+ taskId+ " is performed by " +
                                    Thread.currentThread().getName()
                                )

            );
        }
        executorService.shutdown();
    }
}
