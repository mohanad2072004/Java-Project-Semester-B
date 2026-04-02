package models;

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    // Constructor
    public SimpleDate(int day, int month, int year) {
        if (day <= 0 || day > 30) { // each month has 30 days
            throw new IllegalArgumentException("Invalid day (1-30)");
        }
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("Invalid month (1-12)");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Convert the date to total days for easy calculation
    public int toTotalDays() {
        return year * 360 + (month - 1) * 30 + day; // 12 months × 30 days = 360 days/year
    }

    // Calculate rental days between two dates
    public static int rentalDays(SimpleDate start, SimpleDate end) {
        int days = end.toTotalDays() - start.toTotalDays();
        if (days <= 0) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        return days;
    }

    // Optional: display the date
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
