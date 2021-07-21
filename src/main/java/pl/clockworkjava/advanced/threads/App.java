package pl.clockworkjava.advanced.threads;

public class App {

    public static void main(String[] args) {

        System.out.println("Główny wątek aplikacji: " + Thread.currentThread().getName());

        Thread thread = new MyThread("My-Thread-1");
        Thread secondThread = new MyThread("My-Thread-2");
        Thread thirdThread = new NewThread("Trzeci");

//        thread.start();
//        secondThread.start(); //method start makes new thread
//        thirdThread.run();
//        thirdThread.start();

        Runnable myRunnable = new MyRunnable();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Wątek aplikacji z injection (runnable) to: " + Thread.currentThread().getName());
            }
        };


        Thread fourth = new Thread(runnable, "Runnable with injection");
        Thread fifth = new Thread(myRunnable, "Runnable 1");

        fifth.start();

        fourth.start();


        //Thread with lambda

        Thread lambda = new Thread(
                () -> System.out.println("Wątek aplikacji z lambda (runnable) to: " + Thread.currentThread().getName()),
                "RunnableWithLambda");
        lambda.start();


    }
}
