import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>(Arrays.asList("Alice", "Bob", "Anna", "Charlie", "David"));
        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = students.iterator();
        while (iterator.hasNext()) {
            String student = iterator.next();
            if (student.startsWith("A")) {
                iterator.remove();
            }
        }

        System.out.println("After removal:");
        iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        LinkedList<String> cities = new LinkedList<>(Arrays.asList("New York", "London", "Paris", "Tokyo", "Sydney"));
        ListIterator<String> listIterator = cities.listIterator();
        
        System.out.println("Forward traversal:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("Reverse traversal:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        Vector<String> countries = new Vector<>(Arrays.asList("USA", "India", "Canada", "Australia", "UK"));
        Enumeration<String> enumeration = countries.elements();

        System.out.println("Countries:");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
