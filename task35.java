/*Task 1: Implement a method that returns an Optional object to avoid NullPointerException
*/

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(getName().orElse("Default Name"));
    }

    public static Optional<String> getName() {
        return Optional.ofNullable(null);
    }
}


/*Task 2: Use Java 8 Date API to get the current date and time and format it in "dd-MM-yyyy" format*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(date.format(formatter));
    }
}
