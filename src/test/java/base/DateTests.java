package base;

import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTests {

    // Specifies dd-MM-yyyy format to be used throughout class
    DateTimeFormatter localDtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Creates LocalDate object representing the current date, based on local time zone
    LocalDate ldCurrent = LocalDate.now();

    // Converts current date into day of the week
    String currentDay = ldCurrent.getDayOfWeek()
            .getDisplayName(TextStyle.FULL, Locale.US);

    // Creates LocalDate object representing Christmas Day 2023
    LocalDate ldChristmas = LocalDate.parse("25-12-2023", localDtf);

    @Test
    /*
    - Returns current date
    - Returns current day of the week
     */
    private void getCurrentDate() {
        System.out.println("Current date: " + ldCurrent.format(localDtf));
        System.out.println("Current day of the week: " + currentDay);
    }

    @Test
    /*
    - Returns the number of days until two Tuesdays from current date
    - Returns the date of two Tuesdays from current date
    - The int 16 represents the maximum number of days between current date
      and two Tuesdays, plus one
     */
    private void getFutureSecondTuesday() {
        int currentDayInt = ldCurrent.getDayOfWeek().getValue();
        int dayCount = 16 - currentDayInt;
        LocalDate futureDate = ldCurrent.plusDays(dayCount);

        System.out.println("Number of days until second Tuesday: " + dayCount);
        System.out.println("Date of the second Tuesday: " + futureDate.format(localDtf));
    }

    @Test
    /*
    - Returns number of days from current date until Christmas Day
    - Uses current year only (2023)
     */
    private void getDaysUntilChristmas() {
        long countdown = ChronoUnit.DAYS.between(ldCurrent, ldChristmas);
        System.out.println("Number of days until Christmas: " + countdown);
    }
}
