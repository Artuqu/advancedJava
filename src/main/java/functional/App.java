package functional;

public class App {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        };
//        second way with lambda
        Runnable rl = () -> System.out.println("First lambda");
        Runnable run = () -> System.out.println("Second lambda");

        Comparable<String> cl = st -> 0;
        Movable mv = direction -> 11;

        test("First lambda", run);
        test("Second lambda", rl);
    }

    public static void test(String name, Runnable rn) {
    }
}
