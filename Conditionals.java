package w3resource;

import java.util.Arrays;

/**
 * https://www.w3resource.com/java-exercises/conditional-statement/index.php
 * 
 * @author Ócsai István
 */
public class Conditionals {
 
    /**
     * To solve quadratic equations.
     * @param a
     * @param b
     * @param c
     * @return 
     */
    public static double[] quadraticEquation(double a, double b, double c) {
        double[] result = {Double.NaN, Double.NaN};
        double discriminant = (b * b) - (4 * a * c);
        if (discriminant > 0) {
            result[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            result[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            result = Arrays.copyOfRange(result, 0, 1);
            result[0] = -b / (2 * a);
        }
        return result;
    }
    
    /**
     * Reads in two floating-point numbers and tests whether they are the same
     * up to prec decimal places.
     * @param num1
     * @param num2
     * @param prec
     * @return 
     */
    public static boolean floatEquals(double num1, double num2, int prec) {
        long precision = (long) Math.pow(10, prec);
        int a = (int) (num1 * precision);
        int b = (int) (num2 * precision);
        return a == b;
    }
    
    /**
     * Takes a single character from the alphabet. Returns Vowel or Consonant,
     * depending on the input. If the input is not a letter (between a and z
     * or A and Z), or is a string of length > 1, returns an error message.
     * @param letter
     * @return 
     */
    public static String vowelOrConsonant(String letter) {
        if(letter.length() != 1) {return "Error. Not a single character.";}
        char letterC = letter.toLowerCase().charAt(0);
        if (letterC < 'a' || letterC > 'z') {return "Error. Not a letter.";}
        if (letterC == 'a' || letterC == 'i' || letterC == 'e' 
                || letterC == 'o' || letterC == 'u') {
            return "Vowel";
        }
        return "Consonant";
    }
    
    /**
     * Takes a year from user and returns whether that year is a leap year or 
     * not.
     * @param year
     * @return 
     */
    public static boolean leapYear(int year) {
        return (year % 4) == 0 && ((year % 100) != 0 || (
                (year % 100 == 0) && (year % 400 == 0)));
    }
    
    /**
     * To display the pattern like right angle triangle with a number.
     * @param num
     * @param repeat - will repeat the number in a row.
     * @return 
     */
    public static String numberTriangle(int num, boolean repeat) {
        String result = "";
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                result += repeat ? i : j;
            }
            result += "\n";
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To make such a pattern like right angle triangle with number increased
     * by the increment value.
     * @param rows
     * @param increment
     * @return 
     */
    public static String numberTriangle(int rows, int increment) {
        String result = "";
        int num = 1;
        int actRow = 1;
        while (actRow <= rows) {
            for (int i = 1; i <= actRow; i++) {
                result += num++ + " ";
            }
            result += "\b\n";
            actRow++;
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To make such a pattern like a pyramid with a number.
     * @param rows
     * @param repeat - will repeat the number in the same row.
     * @return 
     */
    public static String numberPyramid(int rows, boolean repeat) {
        String result = "";
        int actRow = 1;
        int num = 0;
        for (int i = 1, j = rows - 1; i <= rows; i++, j--) {
            result += addChars(j, ' ');
            for (int k = 1; k <= actRow; k++) {
                result += (actRow + num) + " ";
                num += repeat ? 0 : 1;
            }
            result += "\b\n";
            actRow++;
            num--;
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To print the Floyd's Triangle.
     * @param rows
     * @return 
     */
    public static String numberFloydTriangle(int rows) {
        String result = "";
        int actRow = 0;
        for (int i = 1; i <= rows; i++) {
            int num = ++actRow;
            for (int j = 1; j <= actRow; j++) {
                result += (num++ % 2) + " ";
            }
            result += "\b\n";
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To display the pattern like a diamond.
     * @param rows - number of rows, half of the diamond.
     * @param pattern
     * @return 
     */
    public static String patternDiamond (int rows, String pattern) {
        String result = "";
        int i = 1;
        for (int j = rows - 1; i <= rows; i++, j--) {
            result += addChars(j, ' ');
            result += addPattern(i, pattern);
        }
        i--;
        for (int j = 1; --i > 0; j++) {
            result += addChars(j, ' ');
            result += addPattern(i, pattern);
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To add one row of pattern.
     * @param num
     * @param pattern
     * @return 
     */
    private static String addPattern(int num, String pattern) {
        String result = "";
        for (int k = 1; k <= 2 * num - 1; k++) {
            result += pattern;
        }
        return result + "\n";
}
    
    /**
     * Creates a string containing number of characters.
     * @param num
     * @param character
     * @return 
     */
    public static String addChars(int num, char character) {
        String result = "";
        for (int k = 0; k < num; k++) {
            result += character;
        }
        return result;
    }
    
    /**
     * To display Pascal's triangle.
     * @param rows
     * @return 
     */
    public static String numberPascalTriangle(int rows) {
        String result = "";
        long num = 1;
        for (int i = 0, j = rows - 1; i < rows; i++, j--) {
            result += addChars(j, ' ');
            for (int k = 0; k <= i; k++) {
                num = (i == 0 || k == 0) ? 1 : num * (i - k + 1) / k;
                result += num + " ";
            }
            result += "\b\n";
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To display the number rhombus structure.
     * @param rows
     * @return 
     */
    public static String numberRhombus(int rows) {
        String result = "";
        int i = 1;
        for (int j = rows - 1; i <= rows; i++, j--) {
            int num = i;
            result += addChars(j, ' ');
            result += addRhombusRow(num, i);
        }
        i--;
        for (int j = 1; --i > 0; j++) {
            int num = i;
            result += addChars(j, ' ');
            result += addRhombusRow(num, i);
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To add one row to the number rhombus.
     * @param num
     * @param row
     * @return 
     */
    private static String addRhombusRow(int num, int row) {
        String result = "";
        while (num > 0) {
            result += num--;
        }
        if (num++ == 0) {
            while (num < row) {
                result += ++num;
            }
        }
        return result + "\n";
    }
    
    /**
     * To display the character rhombus structure.
     * @param rows
     * @return 
     */
    public static String charRhombus(int rows) {
        String result = "";
        int i = 1;
        for (int j = rows - 1; i <= rows; i++, j--) {
            int num = i;
            result += addChars(j, ' ');
            result += addRhombusRow(num);
        }
        i--;
        for (int j = 1; --i > 0; j++) {
            int num = i;
            result += addChars(j, ' ');
            result += addRhombusRow(num);
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * To add one row to the character rhombus.
     * @param num
     * @return 
     */
    private static String addRhombusRow(int num) {
        char nextChar = 'A';
        String result = "";
        for (; nextChar < num + 'A'; nextChar++) {
            result += nextChar;
        }
        nextChar--;
        while (--nextChar >= 'A') {
            result += nextChar;
        }
        return result + "\n";
    }
    
    /**
     * Reads a positive integer and count the number of digits the number
     * (less than ten billion) has.
     * @param num
     * @return 
     */
    public static byte digits(long num) {
        if (num == 0) return 1;
        byte count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    
    /**
     * Accepts three numbers from the user and returns 1 if the numbers are in
     * increasing order, -1 if the numbers are in decreasing order, 
     * and 0 otherwise.
     * @param num1
     * @param num2
     * @param num3
     * @return 
     */
    public static byte numberOrder(int num1, int num2, int num3) {
        if (num1 > num2 && num2 > num3) {
            return -1;
        }
        if (num1 < num2 && num2 < num3) {
            return 1;
        }
        return 0;
    }
}