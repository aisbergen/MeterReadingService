import java.time.LocalDate;
import java.util.*;

public class MeterReadingService {
    public Map<String, User> users;
    public User currentUser;

    public MeterReadingService() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
            return;
        }
        User user = new User(username, password);
        users.put(username, user);
        System.out.println("User registered successfully.");
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Invalid username or password.");
            return false;
        }
        currentUser = user;
        System.out.println("User authenticated successfully.");
        return true;
    }

    public void submitReading(String meterType, double readingValue) {
        if (currentUser == null) {
            System.out.println("User not authenticated.");
            return;
        }
        LocalDate currentDate = LocalDate.now();
        Reading reading = new Reading(meterType, readingValue, currentDate);
        currentUser.addReading(reading);
        System.out.println("Reading submitted successfully.");
    }

    public List<Reading> getCurrentReadings() {
        if (currentUser == null) {
            System.out.println("User not authenticated.");
            return null;
        }
        List<Reading> currentUserReadings = currentUser.getReadings();
        Reading currentReading = currentUserReadings.get(currentUserReadings.size() - 1);
        List<Reading> result = new ArrayList<>();
        result.add(currentReading);
        return result;
    }

    public List<Reading> getReadingsForMonth(int month, int year) {
        if (currentUser == null) {
            System.out.println("User not authenticated.");
            return null;
        }
        List<Reading> currentUserReadings = currentUser.getReadings();
        List<Reading> result = new ArrayList<>();
        for (Reading reading : currentUserReadings) {
            if (reading.getDate().getMonthValue() == month && reading.getDate().getYear() == year) {
                result.add(reading);
            }
        }
        return result;
    }

    public List<Reading> getReadingsHistory() {
        if (currentUser == null) {
            System.out.println("User not authenticated.");
            return null;
        }
        return currentUser.getReadings();
    }

    public void logout() {
        if (currentUser == null) {
            System.out.println("User not authenticated.");
            return;
        }
        currentUser = null;
        System.out.println("User logged out successfully.");
    }
}