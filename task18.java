class Logger {
    private static Logger instance;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(System.currentTimeMillis() + ": " + message);
    }
}

class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {}

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }

    public void disconnect() {
        System.out.println("Disconnected from the database.");
    }
}

enum UserRole {
    ADMIN("Full Access"),
    USER("Limited Access"),
    GUEST("No Access");

    private String accessLevel;

    UserRole(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void printAccessLevel() {
        System.out.println(accessLevel);
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

enum StatusCode {
    SUCCESS("Operation successful"),
    ERROR("Operation failed"),
    PENDING("Operation pending");

    private String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Singleton pattern demo");

        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.connect();
        dbConnection.disconnect();

        UserRole role = UserRole.ADMIN;
        role.printAccessLevel();

        Day today = Day.FRIDAY;
        System.out.println(today.isWeekend() ? "Weekend" : "Weekday");

        StatusCode status = StatusCode.SUCCESS;
        System.out.println(status.getMessage());
    }
}
