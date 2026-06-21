
public class Logger {

    // Step 1: Private static instance
    private static Logger instance;

    // Step 2: Private constructor
    private Logger() {
        System.out.println("Logger instance created!");
    }

    // Step 3: Public static method to get instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Business method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    // Test the Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        logger2.log("User logged in");

        // Check if both references point to same object
        System.out.println("\nAre both instances same? " + (logger1 == logger2));
    }
}