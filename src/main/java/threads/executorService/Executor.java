package threads.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        Thread countdownThread = new Thread(
                () -> {
                    try {
                        System.out.println("Wykonywany wątek (countdown) to: " + Thread.currentThread().getName());
                        for (int i = 1; i <= 10; i++) {
                            System.out.println(i);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted Exception!");
                        e.printStackTrace();
                    }
                }
        );

        Runnable blastOff = () -> {
            System.out.println("Wątek aplikacji z lambda (Threads.join) to: " + Thread.currentThread().getName());
            System.out.println("BlastOff!");
        };
        ex.submit(countdownThread);
        ex.submit(blastOff);

        ex.shutdown();;
//        ex.shutdownNow();;
    }
}
