package Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceCondition {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exs = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            exs.submit(() -> counter.increase());
        }
        exs.shutdown();
        exs.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(counter.getCount());
    }

}

class Counter {
    private int count;

    public void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
