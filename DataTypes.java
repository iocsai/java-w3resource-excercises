package w3resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.w3resource.com/java-exercises/datatypes/index.php
 * 
 * @author Ócsai István
 */
public class DataTypes {
    
    /**
     * Converts temperature from Fahrenheit to Celsius degree.
     * @param fahrenheit
     * @return 
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return ((5 *(fahrenheit - 32.0)) / 9.0);
    }
    
    /**
     * Given a number in inches, converts it to meters.
     * @param inches
     * @return 
     */
    public static double inchesToMeters(double inches) {
        return 0.0254 * inches;
    }
    
    /**
     * Converts minutes into a number of years and days.
     * @param minutes
     * @return 
     */
    public static Map<String, Integer> minsToYearsDays(long minutes) {
        int MINIS_IN_DAY = 24 * 60;
        int MINS_IN_YEAR = 365 * MINIS_IN_DAY;
        int years = (int) (minutes / MINS_IN_YEAR);
        int days = (int) ((minutes / MINIS_IN_DAY % 365));
        Map<String, Integer> result = new HashMap<>(2);
        result.put("Years", years);
        result.put("Days", days);
        return result;
    }
    
    /**
     * Prints the current time in GMT.
     * @param timeZoneChange
     * @return 
     */
    public static String currTimeGMT(int timeZoneChange) {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = ((totalHours + timeZoneChange) % 24);
        return "Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond;
    }
    
    /**
     * Computes body mass index (BMI).
     * @param weight input weight in kg.
     * @param height input height in cm.
     * @return 
     */
    public static double bodyMassIndex(double weight, double height) {
        return weight / square(height / 100);
    }

    /**
     * Returns the square of a given number.
     * @param base
     * @return 
     */
    public static double square(double base) {
        return base * base;
    }
    
    /**
     * Takes the user for a distance (in meters) and the time was taken
     * (as three numbers: hours, minutes, seconds), and display the speed,
     * in meters per second, kilometers per hour and miles per hour
     * @param dist
     * @param hours
     * @param mins
     * @param secs
     * @return 
     */
    public static Map<String, Double> avgSpeed(int dist, int hours, int mins,
            int secs) {
        final double MILE = 1.609; // kilometers
        Map<String, Double> result = new HashMap<>(3);
        int seconds = hours * 3600 + mins * 60 + secs;
        result.put("m/s", (double) dist / seconds);
        result.put("km/h", result.get("m/s") * 3.6);
        result.put("mph", result.get("km/h") / MILE);
        return result;
    }
    
    /**
     * Breaks an integer into a sequence of individual digits.
     * @param num
     * @return 
     */
    public static List<String> intDigits(int num) {
        List<String> result = new ArrayList<>();
        while (num != 0) {
            result.add(String.valueOf(num % 10));
            num /= 10;
        }
        return reverseList(result);
    }

    /**
     * Returns a reverse of the source list.
     * @param source
     * @return 
     */
    public static List<String> reverseList(List<String> source) {
        List<String> reverse = new ArrayList<>(source.size());
        for (int i = source.size() - 1; i >= 0; i--) {
            reverse.add(source.get(i));
        }
        return reverse;
    }
}