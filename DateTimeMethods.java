package w3resource;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

/**
 * https://www.w3resource.com/java-exercises/datetime/index.php
 *
 * @author Ócsai István
 */
public class DateTimeMethods {
    
    /**
     * To check a year is a leap year or not.
     * @param year
     * @return 
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
    
    /**
     * To get year and months between two dates
     * @param begin
     * @param end
     * @return 
     */
    public static Pair<Integer, Integer> yearsMonthsBetween(
            LocalDate begin, LocalDate end) {
        int yearsBetween = end.getYear() - begin.getYear();
        int monthsRemain = end.getMonthValue() - begin.getMonthValue();
        if (monthsRemain < 0) {
            yearsBetween--;
            monthsRemain += 12;
        }
        return new MutablePair<>(yearsBetween, monthsRemain);
    }
    
    /**
     * To get the current time in all the available time zones.
     * @return 
     */
    public static HashMap<String, LocalDateTime> allTimezones() {
        HashMap<String, LocalDateTime> result = new HashMap<>();
        ZoneId.SHORT_IDS.keySet().
            stream().forEach( 
                zoneKey ->
                        result.put(zoneKey, 
                                LocalDateTime.now(ZoneId.of(
                                        ZoneId.SHORT_IDS.get(zoneKey)))));
        return result;
    }
    
    /**
     * To get the months remaining in the year.
     * @return 
     */
    public static int monthsRemainingThisYear() {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        Period untilEndOfYear = today.until(lastDayOfYear);
        return untilEndOfYear.getMonths();
    }
    
    /**
     * To compute the difference between two dates (year, months, days).
     * @param begin
     * @param end
     * @return 
     */
    public static Triple yearsMonthsDaysBetween(LocalDate begin, LocalDate end) {
        Period daysBetween = begin.until(end);
        return new MutableTriple(daysBetween.getYears(),
                daysBetween.getMonths(), 
                daysBetween.getDays());
    }
    
    /**
     * To compute the difference between two dates (Hours, minutes, milli,
     * seconds and nano)
     * @param begin
     * @param end
     * @return 
     */
    public static String hoursMinutesSecsNanosBetween(
            LocalDateTime begin, LocalDateTime end) {
        return "Hours: " + Duration.between(begin, end).toHours() + "\n" +
                "Minutes: " + Duration.between(begin, end).toMinutes() + "\n" +
                "Seconds: " + Duration.between(begin, end).getSeconds() + "\n" +
                "Nanoseconds: " + Duration.between(begin, end).getNano()
                ;
    }
    
    /**
     * To calculate your age.
     * @param birthday
     * @return 
     */
    public static String calculateAge(LocalDate birthday) {
        Period age = Period.between(birthday, LocalDate.now());
        return "You are " + age.getYears() + " years " + 
                age.getMonths() + " months " +
                age.getDays() + " days old";
    }
    
    /**
     * To calculate your age.
     * @param birthday
     * @return 
     */
    public static String calculateAge(LocalDateTime birthday) {
        Period age = Period.between(birthday.toLocalDate(), LocalDate.now());
        Duration ageH = Duration.between(birthday, LocalDateTime.now());
        return "You are " + age.getYears() + " years " + 
                age.getMonths() + " months " +
                age.getDays() + " days " +
                ageH.toHours() % 24 + " hours " +
                ageH.toMinutes() % 60  + " minutes old";
    }
}