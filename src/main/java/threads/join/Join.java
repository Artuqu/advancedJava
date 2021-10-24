package threads.join;

public class Join {
    public static void main(String[] args) throws InterruptedException {

        Runnable blastOff = () -> {
            System.out.println("Wątek aplikacji z lambda (Threads.join) to: " + Thread.currentThread().getName());
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


        Thread j = new Thread(blastOff,"Runnable with Threads.join");


    countdownThread.start();
        System.out.println("Threads.Main thread of application is " + Thread.currentThread().getName());
    countdownThread.join();
    j.start();
    }
}
