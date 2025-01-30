import java.util.Scanner;

public class StringOperations {

    public static String reverseString(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

    public static boolean isPalindrome(String inputString) {
        return inputString.equals(reverseString(inputString));
    }

    public static int countOccurrences(String inputString, char charToCount) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == charToCount) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userString = scanner.nextLine();

        String reversedStr = reverseString(userString);
        System.out.println("Reversed string: " + reversedStr);

        if (isPalindrome(userString)) {
            System.out.println("The string '" + userString + "' is a palindrome.");
        } else {
            System.out.println("The string '" + userString + "' is NOT a palindrome.");
        }

        System.out.print("Enter a character to count occurrences: ");
        char charToCount = scanner.next().charAt(0);

        int occurrenceCount = countOccurrences(userString, charToCount);
        System.out.println("The character '" + charToCount + "' appears " + occurrenceCount + " time(s) in the string.");
    }
}
