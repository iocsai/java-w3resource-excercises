package w3resource;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.w3resource.com/java-exercises/string/index.php
 *
 * @author Ócsai István
 */
public class StringMethods {
    
    /**
     * To get the character (Unicode code point) before the specified index
     * within the String.
     * @param str
     * @param index
     * @return 
     */
    public static int codeBeforeIndex(String str, int index) {
        return str.codePointBefore(index);
    }
    
    /**
     * To count a number of Unicode code points in the specified text range
     * of a String.
     * @param str
     * @param beginIndex
     * @param endIndex
     * @return 
     */
    public static int codeCount(String str, int beginIndex, int endIndex) {
        return str.codePointCount(beginIndex, endIndex);
    }
    
    /**
     * To create a new String object with the contents of a character array.
     * @param charArray
     * @return 
     */
    public static String createString(char[] charArray) {
        return String.copyValueOf(charArray);
    }
    
    /**
     * To print current date and time in the specified format.
     * @return 
     */
    public static String currentDateTime() {
        Calendar c = Calendar.getInstance();
        return String.format("%tB %te, %tY%n%tl:%tM %tp%n", c, c, c, c, c, c);
    }
    
    /**
     * To get the contents of a given string as a byte array.
     * @param str
     * @return 
     */
    public static byte[] stringToByteArray(String str) {
        return str.getBytes();
    }
    
    /**
     * To get the contents of a given string as a character array.
     * @param str
     * @return 
     */
    public static char[] strinigToCharArray(String str) {
        // str.getChars(0, 0, dst, 0);
        return str.toCharArray();
    }
    
    /**
     * To create a unique identifier of a given string.
     * @param str
     * @return 
     */
    public static int stringHash(String str) {
        return str.hashCode();
    }
    
    /**
     * To get the index of all the characters of the alphabet.
     * @param str
     * @param caseSense
     * @return 
     */
    public static HashMap firstLetterIndexes(String str, boolean caseSense) {
        if (!caseSense) {
            str = str.toLowerCase();
        }
        HashMap<Character, Integer> result = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            result.put(c, str.indexOf(c, 0));
        }
        return result;
    }
    
    /**
     * To get the last index of all the characters of the alphabet.
     * @param str
     * @param caseSense
     * @return 
     */
    public static HashMap lastLetterIndexes(String str, boolean caseSense) {
        if (!caseSense) {
            str = str.toLowerCase();
        }
        HashMap<Character, Integer> result = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            result.put(c, str.lastIndexOf(c, str.length() - 1));
        }
        return result;
    }
    
    /**
     * To display the middle character(s) of a string.
     * @param str
     * @return 
     */
    public static String stringMiddle(String str) {
        boolean isEven = (str.length() % 2 == 1);
        int begin = (str.length() - 1) / 2;
        int end = isEven ? 1 : 2;
        return str.substring(begin, begin + end);
    }
    
    /**
     * To count all vowels in a string.
     * @param str
     * @return 
     */
    public static int countVowels(String str) {
        int count = 0;
        final String VOWELS = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            count += VOWELS.contains(Character.toString(str.charAt(i))) ? 1 : 0;
        }
        return count;
    }
    
    /**
     * To count all words in a string.
     * @param str
     * @return 
     */
    public static int countWords(String str) {
        return str.split(" ").length;
    }
}
