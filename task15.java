import java.util.*;

public class Main {
    public static void main(String[] args) {
        addAndRetrieveFromLists();
        demonstrateTreeSetSorting();
        storeStudentDetails();
        countWordFrequency();
        findDuplicateInArrayList();
        removeDuplicatesUsingHashSet();
    }

    public static void addAndRetrieveFromLists() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Alice");
        arrayList.add("Bob");
        arrayList.add("Charlie");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("John");
        linkedList.add("Jane");
        linkedList.add("Tom");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }

    public static void demonstrateTreeSetSorting() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");

        System.out.println("TreeSet (Sorted): " + treeSet);
    }

    public static void storeStudentDetails() {
        HashMap<Integer, String> studentDetails = new HashMap<>();
        studentDetails.put(101, "Alice");
        studentDetails.put(102, "Bob");
        studentDetails.put(103, "Charlie");

        System.out.println("Student Details: " + studentDetails);
        System.out.println("Student with Roll Number 102: " + studentDetails.get(102));
    }

    public static void countWordFrequency() {
        String sentence = "this is a test sentence and this is a test";
        String[] words = sentence.split(" ");
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequency: " + wordCount);
    }

    public static void findDuplicateInArrayList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 5, 3));
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> uniqueElements = new HashSet<>();

        for (Integer number : list) {
            if (!uniqueElements.add(number)) {
                duplicates.add(number);
            }
        }

        System.out.println("Duplicate elements: " + duplicates);
    }

    public static void removeDuplicatesUsingHashSet() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 3, 2, 5);
        Set<Integer> uniqueSet = new HashSet<>(integers);

        System.out.println("List after removing duplicates: " + uniqueSet);
    }
}
