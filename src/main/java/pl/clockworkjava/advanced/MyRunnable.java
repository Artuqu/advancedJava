package pl.clockworkjava.advanced;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Wątek aplikacji (runnable) to: " + Thread.currentThread().getName());
    }
}
