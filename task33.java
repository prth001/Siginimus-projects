import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {

   
        List<Student> students = Arrays.asList(
            new Student("John", 85),
            new Student("Alice", 90),
            new Student("Bob", 75),
            new Student("Eve", 88)
        );

        List<Student> filteredStudents = students.stream()
            .filter(student -> student.getMarks() > 80) 
            .collect(Collectors.toList()); 

        System.out.println("Students with marks above 80:");
        filteredStudents.forEach(student -> System.out.println(student.getName() + ": " + student.getMarks()));

   
        List<String> names = Arrays.asList("john", "alice", "bob", "eve");

        List<String> uppercaseNames = names.stream()
            .map(String::toUpperCase)  
            .collect(Collectors.toList());  

        System.out.println("\nNames in uppercase:");
        uppercaseNames.forEach(System.out::println);

        // Task 3: Find the sum of all numbers in a list using reduce()
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        int sum = numbers.stream()
            .reduce(0, Integer::sum);  

        System.out.println("\nSum of numbers: " + sum);
    }
}

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}
