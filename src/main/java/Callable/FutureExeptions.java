package Callable;

import java.util.concurrent.*;

public class FutureExeptions {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exs = Executors.newFixedThreadPool(5);

        final boolean err = true;

        CompletableFuture.runAsync(
                () -> System.out.println("Thread: " + Thread.currentThread().getName()), exs
        );

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (err) {
                throw new IllegalArgumentException("Wrong argument");
            }
            return 42;
        }, exs).exceptionally(exception -> {
            System.out.println("ERROR! " + exception.getMessage());
            return 2;
        }).thenApply(r -> {
            System.out.println("*2 " + Thread.currentThread().getName());
            return r * 2;
        }).thenApply(r -> {
            System.out.println("+1 " + Thread.currentThread().getName());
            return r + 1;
        }).thenAccept(r -> {
            System.out.println("sout " + Thread.currentThread().getName());
            System.out.println(r);
        });


        exs.shutdown();
    }
}
