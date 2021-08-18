package Callable;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        without lambda
//        Callable<Integer> answerToEverything = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                TimeUnit.SECONDS.sleep(10);
//                return 42;
//            }
//        };


        ExecutorService exs = Executors.newFixedThreadPool(1);

//        with lambda
        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 42;
        };

        Future<Integer> result = exs.submit(answerToEverything);
        Integer r = result.get();
        System.out.println(r);
        exs.shutdown();
    }
}
