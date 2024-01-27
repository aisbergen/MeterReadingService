import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Reading> readings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.readings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addReading(Reading reading) {
        readings.add(reading);
    }

    public List<Reading> getReadings() {
        return readings;
    }
}