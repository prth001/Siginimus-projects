import java.io.*;

class AgeValidator {
    public void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be less than 0");
        }
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            closeResource();
        }

        AgeValidator validator = new AgeValidator();
        try {
            validator.validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            readFile("sample.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void closeResource() {
        System.out.println("Resource closed.");
    }

    public static void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        reader.close();
    }
}
