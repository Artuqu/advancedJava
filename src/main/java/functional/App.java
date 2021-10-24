package functional;

public class App {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        Comparable<String> c = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };
    }
}
