package threads.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {

    public static void main(String[] args) {

        System.out.println("Threads.Main thread of application: " + Thread.currentThread().getName());
        ScheduledExecutorService exS = Executors.newScheduledThreadPool(2);

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
//        exS.schedule(worker1, 5, TimeUnit.SECONDS);
//        exS.schedule(worker2, 4, TimeUnit.SECONDS);
//        exS.schedule(worker3, 8, TimeUnit.SECONDS);
//        exS.shutdown();
        exS.scheduleAtFixedRate(worker1,0,6,TimeUnit.SECONDS);
    }
}
