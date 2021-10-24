package threads.callable;

import java.util.concurrent.*;

public class completableFutureNotBlocked {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exs = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Thread: " + Thread.currentThread().getName()), exs
        );

//        CompletableFuture<Integer> integerCompletableFuture =
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        }, exs).thenApply(r -> {
            System.out.println("*2 " + Thread.currentThread().getName());
            return r * 2;
        }).thenApply(r -> {
            System.out.println("+1 " + Thread.currentThread().getName());
            return r + 1;
        }).thenAccept(r -> {
            System.out.println("sout " + Thread.currentThread().getName());
            System.out.println(r);
        });

//        Integer r = integerCompletableFuture.get();

//        System.out.println("New result is " + ((r * 2) + 1));
//        System.out.println(integerCompletableFuture.get());

        exs.shutdown();
    }
}
