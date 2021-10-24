package threads.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService exs = Executors.newFixedThreadPool(2);

        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 42;
        };

        Callable<Integer> anotherAnswerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 43;
        };

        Callable<Integer> finalAnswerToEverything = () -> {
            TimeUnit.SECONDS.sleep(12);
            return 44;
        };

        List<Callable<Integer>> calList = Arrays.asList(anotherAnswerToEverything, answerToEverything, finalAnswerToEverything);

        List<Future<Integer>> futures = exs.invokeAll(calList);

        Integer fastest = exs.invokeAny(calList);

        System.out.println("The fastest thread is with value of " + fastest);

        for (Future<Integer> f : futures){
            System.out.println(f.get());
        }
        exs.shutdown();
    }
}
