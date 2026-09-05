package multithreading.exectorFramework;

import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

public class FutureAndCallable {

    static void main() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> f = executor.submit(() -> {
            try {
                sleep(3000);
            } catch (Exception _) {}
            return 10;
        });

        List<Runnable> list = executor.shutdownNow();
        System.out.println(list);

//        will be rejected - RejectedExecutionException exception thrown
//        Future<Integer> f1 = executor.submit(() -> {
//            try {
//                sleep(3000);
//            } catch (Exception _) {}
//            return 5;
//        });


        try {
            System.out.println(f.get());
        } catch (Exception _) {
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
        //callable
        scheduler.schedule(
                () -> {
                    System.out.println("Runnable scheduled task performed");
                }, 2, SECONDS
        );

        ScheduledFuture<Integer> f1 =  scheduler.schedule(
                () -> {
                    System.out.println("Callable scheduled task performed");
                    return 3;
                }, 2, SECONDS
        );
       System.out.println(f1.get());

//        ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(4);
//        scheduler.schedule(
//                () ->
//                        System.out.println("Scheduled task peformed")
//                ,2, SECONDS
//        );

        scheduler.shutdown();

    }

}
