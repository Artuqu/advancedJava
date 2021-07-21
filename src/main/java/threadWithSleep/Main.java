package threadWithSleep;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        if (a == b) {
            System.out.println(b);
        }

        Thread lambda = new Thread(
                () -> {
                    try {
                        System.out.println("Wątek aplikacji z lambda (runnable) to: " + Thread.currentThread().getName());
                        for (int i = 1; i <= 10; i++) {
                            System.out.println(i);
                            Thread.sleep(1000);
//                            second way
//                            TimeUnit.SECONDS.sleep(1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        );
        lambda.start();
    }
}
