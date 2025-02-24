class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "apple");
        System.out.println(pair.getFirst() + ", " + pair.getSecond());

        Integer[] numbers = {1, 2, 3};
        Pair.swap(numbers, 0, 2);
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Max of 3, 5, and 2: " + Pair.findMax(3, 5, 2));
    }
}
