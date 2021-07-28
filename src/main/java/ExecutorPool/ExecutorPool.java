package ExecutorPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorPool {
    public static void main(String[] args) {

        ExecutorService exp = Executors.newFixedThreadPool(2);

        Runnable worker1 = () -> {
            try {
                System.out.println("Worker 1 - Actual Thread is" + Thread.currentThread().getName());
                System.out.println("Loading oxygen");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable worker2 = () -> {
            try {
                System.out.println("Worker 2 - Actual Thread is" + Thread.currentThread().getName());
                System.out.println("Loading stock of food");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable worker3 = () -> {
            try {
                System.out.println("Worker 3 - Actual Thread is" + Thread.currentThread().getName());
                System.out.println("Loading fuel");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        exp.submit(worker1);
        exp.submit(worker2);
        exp.submit(worker3);
        exp.shutdown();
    }
}
