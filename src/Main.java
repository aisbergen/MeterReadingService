import java.util.List;

public class Main {
    public static void main(String[] args) {
        MeterReadingService service = new MeterReadingService();

        // Register a user
        service.registerUser("user1", "password1");

        // Authenticate the user
        service.authenticateUser("user1", "password1");

        // Submit readings
        service.submitReading("heating", 100.5);
        service.submitReading("hot water", 50.3);
        service.submitReading("cold water", 150.7);

        // Get current readings
        List<Reading> currentReadings = service.getCurrentReadings();
        System.out.println("Current readings: " + currentReadings);

        // Get readings for a specific month
        List<Reading> readingsForMonth = service.getReadingsForMonth(1, 2023);
        System.out.println("Readings for January 2023: " + readingsForMonth);

        // Get reading history
        List<Reading> readingHistory = service.getReadingsHistory();
        System.out.println("Reading history: " + readingHistory);

        // Logout
        service.logout();
    }
}