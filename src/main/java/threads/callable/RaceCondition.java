package threads.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
    private AtomicInteger count = new AtomicInteger(0);
    private AtomicBoolean atb = new AtomicBoolean(false);

//    only one thread has access to method by synchronized
//     public void increase() {
//         System.out.println("First step");
//         System.out.println("Second step");
//
//         synchronized (this){
//             count++;}
//
//         System.out.println("Last step");
//    }

     public void increase() {
//         count++;
         count.getAndIncrement();
     }
    public int getCount() {
        return count.get();
    }
}
