package Callable;

import java.util.concurrent.*;

public class completableJoinCalling {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Long> userIdFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getUserId();
        });

        CompletableFuture<Long> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 34L;
        });


        CompletableFuture<Long> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 596L;
        });


        CompletableFuture<Long> future3 = cf1.thenCombine(cf2, (result1, result2) -> {
            return result1 * result2;
        });


        CompletableFuture<Void> future = userIdFuture.thenCompose(userId -> CompletableFuture.supplyAsync(() -> getDiscount(userId))).thenAccept(
                discount -> System.out.println(discount)
        );

        future.get();
        System.out.println(future3.get());

    }

    public static Long getUserId() {
        return 324L;
    }

    public static Double getDiscount(Long userId) {
        return 0.15;
    }
}