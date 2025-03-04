import java.util.*;
import java.util.function.*;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
    
        List<Integer> numbers = Arrays.asList(5, 12, 8, 15, 3);
        Predicate<Integer> greaterThanTen = num -> num > 10;
        numbers.stream().filter(greaterThanTen.negate()).forEach(System.out::println);

     
        List<String> strings = Arrays.asList("hello", "world", "java");
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        List<String> upperStrings = new ArrayList<>();
        for (String str : strings) {
            upperStrings.add(toUpperCase.apply(str));
        }
        upperStrings.forEach(System.out::println);

      
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        strings.forEach(printUpperCase);

        
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));
        people.sort((p1, p2) -> Character.compare(p1.getName().charAt(1), p2.getName().charAt(1)));
        people.forEach(person -> System.out.println(person.getName()));
    }
}
