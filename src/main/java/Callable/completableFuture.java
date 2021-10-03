package Callable;
import java.util.concurrent.*;


public class completableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exs = Executors.newFixedThreadPool(2);

        CompletableFuture.runAsync(
                () -> System.out.println("Thread: " + Thread.currentThread().getName()),exs
        );

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        },exs);

        System.out.println(integerCompletableFuture.get());

        exs.shutdown();
    }
}
