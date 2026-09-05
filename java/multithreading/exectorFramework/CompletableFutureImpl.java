package multithreading.exectorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureImpl {
    static void main() {
        CompletableFuture<Integer> f =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(result -> result*2)
                        .thenApply(result -> result*3);

        //no output
        CompletableFuture<Void> f1 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(result -> result*2)
                        .thenAccept(result -> System.out.println(result));


        //runnable
        CompletableFuture<Void> f2 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(result -> result*2)
                        .thenRun(() -> System.out.println("Done"));

        CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(
                () -> 10
        );

        CompletableFuture<Integer> f4 = CompletableFuture.supplyAsync(
                () -> 20
        );

        CompletableFuture<Void> res = f3.thenCombine(
                f4, Integer::sum
        ).thenAccept(System.out::println);



//        try {
//            System.out.println(
//                    f2.get()
//            );
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }
}
