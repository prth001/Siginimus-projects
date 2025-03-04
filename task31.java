public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Runnable executed");
        runnable.run();

        Runnable evenNumbers = () -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        };
        evenNumbers.run();
    }
}
