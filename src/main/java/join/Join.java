package join;

import pl.clockworkjava.advanced.threads.App;
import threadWithSleep.Sleep;

public class Join {
    public static void main(String[] args) throws InterruptedException {

        Runnable blastOff = () -> {
            System.out.println("Wątek aplikacji z lambda (join) to: " + Thread.currentThread().getName());
            System.out.println("Join");
        };


        Thread countdownThread = new Thread(
                () -> {
                    try {
                        System.out.println("Wykonywany wątek (countdown) to: " + Thread.currentThread().getName());
                        for (int i = 1; i <= 10; i++) {
                            System.out.println(i);
                            Thread.sleep(1000);

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        );


        Thread j = new Thread(blastOff,"Runnable with join");


    countdownThread.start();
        System.out.println("Main thread of application is " + Thread.currentThread().getName());
    countdownThread.join();
    j.start();
    }
}
