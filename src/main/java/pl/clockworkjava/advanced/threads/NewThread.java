package pl.clockworkjava.advanced.threads;

import java.util.stream.IntStream;

public class NewThread extends Thread {

    public NewThread(String name) {
        super(name);
    }
    @Override
    public void run(){
//        System.out.println("Nowy wątek aplikacji: " + Thread.currentThread().getName());
        IntStream.rangeClosed(1,5).forEach(i -> System.out.println(i + " This " + Thread.currentThread().getName()));
    }
}
