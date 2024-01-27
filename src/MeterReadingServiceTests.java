import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeterReadingServiceTest {

    private MeterReadingService meterReadingService;
    private User user;

    @BeforeEach
    void setUp() {
        meterReadingService = new MeterReadingService();
        meterReadingService.registerUser("user1", "password1");
        user = meterReadingService.users.get("user1");
    }

    @Test
    void registerUser() {
        meterReadingService.registerUser("user2", "password2");
        assertTrue(meterReadingService.users.containsKey("user2"));
    }

    @Test
    void authenticateUser() {
        assertTrue(meterReadingService.authenticateUser("user1", "password1"));
        assertFalse(meterReadingService.authenticateUser("user1", "wrong_password"));
    }

    @Test
    void submitReading() {
        meterReadingService.submitReading("electricity", 100);
        assertEquals(1, user.getReadings().size());
    }

    @Test
    void getCurrentReadings() {
        meterReadingService.submitReading("electricity", 100);
        List<Reading> currentReadings = meterReadingService.getCurrentReadings();
        assertEquals(1, currentReadings.size());
        assertEquals("electricity", currentReadings.get(0).getMeterType());
        assertEquals(100, currentReadings.get(0).getReadingValue());
    }

    @Test
    void getReadingsForMonth() {
        meterReadingService.submitReading("electricity", 100);
        List<Reading> readingsForMonth = meterReadingService.getReadingsForMonth(1, 2022);
        assertEquals(1, readingsForMonth.size());
        assertEquals("electricity", readingsForMonth.get(0).getMeterType());
        assertEquals(100, readingsForMonth.get(0).getReadingValue());
    }

    @Test
    void getReadingsHistory() {
        meterReadingService.submitReading("electricity", 100);
        List<Reading> readingsHistory = meterReadingService.getReadingsHistory();
        assertEquals(1, readingsHistory.size());
        assertEquals("electricity", readingsHistory.get(0).getMeterType());
        assertEquals(100, readingsHistory.get(0).getReadingValue());
    }

    @Test
    void logout() {
        meterReadingService.authenticateUser("user1", "password1");
        assertNotNull(meterReadingService.currentUser);
        meterReadingService.logout();
        assertNull(meterReadingService.currentUser);
    }
}