import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

class CurrencyConverter {
    static final BigDecimal USD_TO_EUR = new BigDecimal("0.85");
    static final BigDecimal USD_TO_GBP = new BigDecimal("0.75");
    static final BigDecimal EUR_TO_USD = new BigDecimal("1.18");
    static final BigDecimal EUR_TO_GBP = new BigDecimal("0.88");
    static final BigDecimal GBP_TO_USD = new BigDecimal("1.33");
    static final BigDecimal GBP_TO_EUR = new BigDecimal("1.14");

    public static BigDecimal convert(BigDecimal amount, String fromCurrency, String toCurrency) {
        BigDecimal exchangeRate = BigDecimal.ZERO;
        
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            exchangeRate = USD_TO_EUR;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            exchangeRate = USD_TO_GBP;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            exchangeRate = EUR_TO_USD;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            exchangeRate = EUR_TO_GBP;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            exchangeRate = GBP_TO_USD;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            exchangeRate = GBP_TO_EUR;
        }

        return amount.multiply(exchangeRate);
    }
}

final class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}

public class Main {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("100");
        System.out.println("100 USD to EUR: " + CurrencyConverter.convert(amount, "USD", "EUR"));
        
        Person person = new Person("John", "Doe", LocalDate.of(1990, 1, 1));
        System.out.println("Full Name: " + person.getFullName());
        System.out.println("Age: " + person.getAge());
    }
}
