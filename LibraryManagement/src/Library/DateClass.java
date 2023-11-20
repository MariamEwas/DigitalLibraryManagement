package Library;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateClass {
	private int day;
    private int month;
    private int year;

    public DateClass(int day, int month, int year) {
    	this.year = year;
        this.month = month;
        if (month > 12) {
            // Increment the year
            setYear(year + 1);
            // Reset the month to January of the next year
            this.month = 1;
        } else {
            this.month = month;
        }  
        setDay(day);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        // Check if the day exceeds the maximum days in the current month
        while (day > getDaysInMonth()) {
            // Increment the month
            setMonth(month + 1);
            // Reset the day to the first day of the next month
            day = day-getDaysInMonth();
        } 
            this.day = day;
        
    }

    public void setMonth(int month) {
        // Check if the month exceeds 12
        if (month > 12) {
            // Increment the year
            setYear(year + 1);
            // Reset the month to January of the next year
            this.month = 1;
        } else {
            this.month = month;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public long getDaysBetween(DateClass otherDate) {
        LocalDate thisLocalDate = LocalDate.of(year, month, day);
        LocalDate otherLocalDate = LocalDate.of(otherDate.getYear(), otherDate.getMonth(), otherDate.getDay());

        return ChronoUnit.DAYS.between(thisLocalDate, otherLocalDate);
    }

    private int getDaysInMonth() {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }
    public int compareTo(DateClass otherDate) {
        LocalDate thisLocalDate = LocalDate.of(year, month, day);
        LocalDate otherLocalDate = LocalDate.of(otherDate.getYear(), otherDate.getMonth(), otherDate.getDay());

        return thisLocalDate.compareTo(otherLocalDate);
    }
}
