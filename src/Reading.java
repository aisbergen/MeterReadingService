import java.time.LocalDate;

public class Reading {
    private String meterType;
    private double readingValue;
    private LocalDate date;

    public Reading(String meterType, double readingValue, LocalDate date) {
        this.meterType = meterType;
        this.readingValue = readingValue;
        this.date = date;
    }

    public String getMeterType() {
        return meterType;
    }

    public double getReadingValue() {
        return readingValue;
    }

    public LocalDate getDate() {
        return date;
}}
