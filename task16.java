public class Main {
    public static void main(String[] args) {
        int[] arrayForBubbleSort = {5, 3, 8, 4, 2};
        int[] arrayForSelectionSort = {5, 3, 8, 4, 2};

        bubbleSort(arrayForBubbleSort);
        selectionSort(arrayForSelectionSort);

        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci sequence up to 5 terms: ");
        generateFibonacci(5);

        System.out.println("Reversed string: " + reverseString("Hello"));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("Bubble sorted array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("Selection sorted array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void generateFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
