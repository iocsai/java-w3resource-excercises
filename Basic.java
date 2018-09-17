package w3resource;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * https://www.w3resource.com/java-exercises/basic/index.php
 * 
 * @author Ócsai István
 */
public class Basic {
    
    /**
     * Returns 'Hello' and your name on a separate line.
     * @param yourName
     * @return 
     */
    public static String hello(String yourName) {
        return ("Hello\n" + yourName);
    }
    
    /**
     * Returns the sum of two numbers.
     * @param num1
     * @param num2 
     * @return  
     */
    public static String sum(int num1, int num2) {
        return "" + (num1 + num2);
    }
    
    /**
     * Divides two int numbers.
     * @param num1
     * @param num2 
     * @return  
     */
    public static String divide(int num1, int num2) {
        return "" + (num1 / num2);
    }
    
    /**
     * Takes two numbers as input and returns the product of two numbers. 
     * @param num1
     * @param num2
     * @return 
     */
    public static String product(int num1, int num2) {
        return (num1 + " x " + num2 + " = " + num1 * num2);
    }
    
    /**
     * Returns the sum (addition), multiply, subtract,  divide and remainder of
     * two numbers.
     * @param num1
     * @param num2
     * @return 
     */
    public static String allOperations(int num1, int num2) {
        return (num1 + " + " + num2 + " = " + (num1 + num2) + "\n" +
                num1 + " - " + num2 + " = " + (num1 - num2) + "\n" +
                num1 + " x " + num2 + " = " + (num1 * num2)+ "\n" +
                num1 + " / " + num2 + " = " + (num1 / num2) + "\n" +
                num1 + " mod " + num2 + " = " + (num1 / num2)
        );
    }
    
    /**
     * Takes a number as input and returns its multiplication table.
     * @param base
     * @param upto
     * @return 
     */
    public static String multiTable(int base, int upto) {
        String result = "";
        for (int i = 1; i <= upto; i++) {
            result += base + " x " + i + " = " + (base * i) + "\n";
        }
        return result;
    }
    
    /**
     * To display a JaVa pattern.
     * @return 
     */
    public static String javaPattern() {
        return "   J    a   v     v  a\n" + 
                "   J   a a   v   v  a a\n" +
                "J  J  aaaaa   V V  aaaaa\n" +
                " JJ  a     a   V  a     a\n";
    }
    
    /**
     * Returns the area and perimeter of a circle.
     * @param radius
     * @return 
     */
    public static String areaPerimeter(double radius) {
        return "Perimeter is = " + (2 * Math.PI * radius) + "\n" +
                "Area is = " + (Math.PI * Math.pow(radius, 2));
    }

    /**
     * Returns the area and perimeter of a rectangle.
     * @param width
     * @param height
     * @return 
     */
    public static String areaPerimeter(double width, double height) {
        return "Perimeter is = " + (2 * (width + height)) + "\n" +
                "Area is = " + (width * height);        
    }

    /**
     * Adds two binary numbers.
     * @param binary1
     * @param binary2
     * @return 
     */
    public static String sumBinaries(long binary1, long binary2) {
        int i = 0;
        int remainder = 0;
        int[] sum = new int[32];
        while (binary1 != 0 || binary2 != 0) {
            int n = (int)(binary1 % 10 + binary2 %10 + remainder);
            sum[i++] = n % 2;
            remainder = n / 2;
            binary1 /= 10;
            binary2 /= 10;
        }
        if (remainder == 1) {
            sum[i++] = remainder;
        }
        return arrayToString(sum);
    }
    
    /**
     * Multiply two binary numbers. 
     * @param binary1
     * @param binary2
     * @return 
     */
    public static String multiplyBinaries(long binary1, long binary2) {
        long sum = 0;
        long deci = numberToDecimal(binary2, 2);
        for (int i = 1; i < deci; i++) {
            sum += Long.parseLong(sumBinaries(binary1, sum));
        }
        return Long.toString(sum);
    }

    /**
     * Converts a decimal number to binary number. 
     * @param decimal
     * @return 
     */
    public static String decimalToBinary(int decimal) {
        int[] binary = new int[32];
        int i = 0;
        while (decimal != 0) {
            binary[i++] = decimal % 2;
            decimal /= 2;
        }
        return arrayToString(binary);
    }
    
    /**
     * Converts a decimal number to a numSystem number.
     * @param decimal
     * @param numSystem
     * @return 
     */
    public static String decimalToNumsys(int decimal, int numSystem) {
        if (numSystem == 10) {
            return Integer.toString(decimal);
        }
        List<Integer> result = new ArrayList(1);
        int i = 0;
        while (decimal != 0) {
            result.add(decimal % numSystem);
            decimal /= numSystem;
        }
        return listToString(result, numSystem);
    }
    
    /**
     * Converts a numSystem (max. 10) number to a decimal number.
     * @param number
     * @param numSystem
     * @return 
     */
    @Deprecated
    public static long numberToDecimal(long number, int numSystem) {
        if (numSystem == 10) {
            return number;
        }
        long result = 0;
        int exponent = 0;
        while (number != 0) {
            result += number % 10 * Math.pow(numSystem, exponent++);
            number /= 10;
        }
        return result;
    }
    
    /**
     * Converts a numSystem number to a decimal number.
     * @param number
     * @param numSystem
     * @return 
     */
    public static long numberToDecimal(String number, int numSystem) {
        if (numSystem == 10) {
            return Integer.parseInt(number);
        }
        long result = 0;
        int exponent = 0;
        
        while (number.length() != 0) {
            char lastChar = number.charAt(number.length() - 1);
            
            result += Character.isDigit(lastChar) ?
                    (lastChar - 48) % 10 * Math.pow(numSystem, exponent++) :
                    (lastChar - 55) * Math.pow(numSystem, exponent++);
            number = number.substring(0, number.length() - 1);
        }
        return result;
    }
    
    /**
     * Converts a decimal number to octal number.
     * @param decimal
     * @return 
     */
    public static String decimalToOctal(int decimal) {
        return decimalToNumsys(decimal, 8);
    }
    
    /**
     * Converts a decimal number to hexadacimal number.
     * @param decimal
     * @return 
     */
    public static String decimalToHexa(int decimal) {
        return decimalToNumsys(decimal, 16);
    }
    
    /**
     * Converts a binary number to a decimal number.
     * @param binary
     * @return 
     */
    public static String binaryToDecimal(long binary) {
        return Long.toString(numberToDecimal(binary, 2));
    }
    
    /**
     * Converts a binary number to a hexadecimal number.
     * @param binary
     * @return 
     */
    public static String binaryToHexa(long binary) {
        int deci = (int) numberToDecimal(binary, 2);
        return decimalToNumsys(deci, 16);
    }
    
    /**
     * Converts a binary number to an octal number. 
     * @param binary
     * @return 
     */
    public static String binaryToOctal(long binary) {
        int deci = (int) numberToDecimal(binary, 2);
        return decimalToNumsys(deci, 8);
    }
    
    /**
     * Converts an octal number to a decimal number.
     * @param octal
     * @return 
     */
    public static String octalToDecimal(int octal) {
        return Long.toString(numberToDecimal(octal, 8));
    }
    
    /**
     * Converts an octal number to a hexadecimal number.
     * @param octal
     * @return 
     */
    public static String octalToHexa(int octal) {
        int deci = (int) numberToDecimal(octal, 8);
        return decimalToNumsys(deci, 16);
    }
    
    /**
     * Converts an octal number to a binary number.
     * @param octal
     * @return 
     */
    public static String octalToBinary(int octal) {
        int deci = (int) numberToDecimal(octal, 8);
        return decimalToNumsys(deci, 2);
    }
    
    /**
     * Converts a hexadecimal number to a decimal number.
     * @param hexa
     * @return 
     */
    public static String hexaToDecimal(String hexa) {
        return Long.toString(numberToDecimal(hexa, 16));
    }
    
    /**
     * Converts a hexadecimal number to an octal number.
     * @param hexa
     * @return 
     */
    public static String hexaToOctal(String hexa) {
        int deci = (int) numberToDecimal(hexa, 16);
        return decimalToNumsys(deci, 8);
    }
    
    /**
     * Converts a hexadecimal number to a binary number.
     * @param hexa
     * @return 
     */
    public static String hexaToBinary(String hexa) {
        int deci = (int) numberToDecimal(hexa, 16);
        return decimalToNumsys(deci, 2);
    }
    
    /**
     * Compares two int numbers.
     * @param num1
     * @param num2
     * @return 
     */
    public static String compareInts(int num1, int num2) {
        String result = "";
        if (num1 == num2) {
            result += num1 + " == " + num2 + "\n"
                    + num1 + " <= " + num2 + "\n"
                    + num1 + " >= " + num2 + "\n";
        } else {
            result += num1 + " != " + num2 + "\n";
            if (num1 < num2) {
                result += num1 + " < " + num2 + "\n"
                        + num1 + " <= " + num2 + "\n";
            } else {
                result += num1 + " > " + num2 + "\n"
                        + num1 + " >= " + num2 + "\n";
            }
        }
        return result;
    }

    /**
     * Computes the sum of the digits of an integer.
     * @param number
     * @return 
     */
    public static int sumDigits(long number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
    
    /**
     * Computes the area of a hexagon.
     * @param length
     * @return 
     */
    public static double hexagonArea(double length) {
        return polygonArea(6, length);
    }

    /**
     * Computes the area of a polygon.
     * @param sides
     * @param length
     * @return 
     */
    public static double polygonArea(double sides, double length) {
        return (sides * Math.pow(length, 2)) /
                (4 * Math.tan(Math.PI / sides));        
    }
    
    /**
     * Computes the distance between two points on the surface of earth.
     * @param point1
     * @param point2
     * @return 
     */
    public static double distanceOnEarth(Coordinate point1, Coordinate point2) {
        final double EARTH_RADIUS = 6371.01; // Earth's radius in kilometers
        return EARTH_RADIUS * Math.acos((Math.sin(point1.latitude) *
                Math.sin(point2.latitude)) + (Math.cos(point1.latitude) *
                        Math.cos(point2.latitude) *
                        Math.cos(point1.longitude - point2.longitude)));
    }
    
    /**
     * To reverse a string.
     * @param original
     * @return 
     */
    public static String reverseString(String original) {
        String result = "";
        while (original.length() != 0) {
            result += original.substring(original.length() - 1);
            original = original.substring(0, original.length() - 1);
        }
        return result;
    }
    
    /**
     * Counts the letters, spaces, numbers and other characters of the input
     * string.
     * @param str
     * @return 
     */
    public static String countCharByType(String str) {
        int letter = 0;
        int number = 0;
        int space =0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            char nextChar = str.charAt(i);
            if (Character.isLetter(nextChar)) {
                letter++;
            } else if (Character.isDigit(nextChar)) {
                number++;
            } else if (Character.isSpaceChar(nextChar)) {
                space++;
            } else {
                other++;
            }
        }
        return "letter: " + letter + "\nspace: " + space +
                "\nnumber: " + number + "\nother: " + other + "\n";
    }
    
    /**
     * Creates unique three-digit numbers using 1..maxValue. Also count how
     * many three-digit numbers are there.
     * @param maxValue
     * @return 
     */
    public static String threeDigitNumbers(int maxValue) {
        String result = "";
        int count = 0;
        for (int i = 1; i <= maxValue; i++) {
            String strI = Integer.toString(i);
            for (int j = 1; j <= maxValue; j++) {
                String strJ = Integer.toString(j);
                for (int k = 1; k <= maxValue; k++) {
                    String strK = Integer.toString(k);
                    if (k != i && k != j && i != j) {
                        result += strI + strJ + strK + "\n";
                        count++;
                    }
                }
            }
        }
        return result + 
                "Total number of the three-digit-number is " + count + "\n";
    }
    
    /**
     * Lists the available character sets in charset objects.
     * @return 
     */
    public static String availableCharSets() {
        String result = "";
        result = Charset.availableCharsets().keySet().stream()
                .map((str) -> str + "\n").reduce(result, String::concat);
        return result;
    }
    
    /**
     * Returns the odd numbers from 1 to maxValue, one number per line.
     * @param maxValue
     * @return 
     */
    public static String oddNumbers(int maxValue) {
        String result = "";
        int nextNum = 1;
        while (nextNum <= maxValue) {
            result += nextNum + "\n";
            nextNum += 2;
        }
        return result;
    }
    
    /**
     * Checks number is even or not. Returns 1 if the number is even or 0 if
     * the number is odd.
     * @param number
     * @return 
     */
    public static int isEven(int number) {
        return number % 2 == 0 ? 1 : 0;
    }
    
    /**
     * Calculates the sum of two integers and returns true if the sum is equal
     * to a third integer.
     * @param num1
     * @param num2
     * @param num3
     * @return 
     */
    public static boolean isEquals(int num1, int num2, int num3) {
        return (num1 + num2) == num3
                || (num1 + num3) == num2
                || (num3 + num2) == num1;
    }
    
    /**
     * Accepts three integers and returns true if the second number is greater 
     * than first number and third number is greater than second number.
     * If "abc" is true second number does not need to be greater than
     * first number.
     * @param p
     * @param q
     * @param r
     * @param abc
     * @return 
     */
    public static boolean isIncreasing(int p, int q, int r, boolean abc) {
        if(abc) return (r > q);
        return (q > p && r > q);
    }
    
    /**
     * Accepts three non-negative integers and returns true if two or more of 
     * them have the same rightmost digit.
     * @param num1
     * @param num2
     * @param num3
     * @return 
     */
    public static boolean hasEqualLastDigit(int num1, int num2, int num3) {
        return (num1 % 10 == num2 % 10) 
                || (num2 % 10 == num3 % 10)
                || (num1 % 10 == num3 % 10);
    }
    
    /**
     * Converts seconds to hour, minute and seconds.
     * @param secs
     * @return 
     */
    public static String convertSeconds(long secs) {
        return (secs / 3600) + ":" + (secs / 60) % 60 + ":" + (secs % 60);
    }
    
    /**
     * Finds the number of integers within the range of two specified numbers
     * and that are divisible by another number.
     * @param start
     * @param end
     * @param divider
     * @return 
     */
    public static int countDivisibles(int start, int end, int divider) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += (i % divider == 0) ? 1 : 0;
        }
        return count;
    }
    
    /**
     * Accepts an integer and counts the countPrimeFactors of the number.
     * @param num
     * @return 
     */
    public static int countPrimeFactors(int num) {
        int count = 0;
        for(int i = 1; i <= (int) Math.sqrt(num); i++) {
            if(num%i==0 && i*i!=num) {
                count+=2;
            } else if (i*i==num) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Capitalizes the first letter of each word in a sentence.
     * @param str
     * @return 
     */
    public static String capitalizeFirstLetters(String str) {
        Scanner lineScan = new Scanner(str);
        String result = "";
        while(lineScan.hasNext()) {
            String word = lineScan.next();
            result += Character.toUpperCase(word.charAt(0)) 
                    + word.substring(1) + " ";
        }
        return result;
    }
    
    /**
     * Returns true if one of the three integer values is diff or more less 
     * than one of the others.
     * @param num1
     * @param num2
     * @param num3
     * @param diff
     * @return 
     */
    public static boolean isDifference(int num1, int num2, int num3, int diff) {
        return (Math.abs(num1 - num2) >= diff)
                || (Math.abs(num1 - num3) >= diff)
                || (Math.abs(num3 - num2) >= diff);
    }
    
    /**
     * Accepts two integer values and returns true if there is a common digit
     * in both numbers.
     * @param num1
     * @param num2
     * @return 
     */
    public static boolean commonDigit(int num1, int num2) {
        List<Integer> digits = new ArrayList<>();
        while (num1 > 0) {
            digits.add(num1 % 10);
            num1 /= 10;
        }
        while (num2 > 0) {
            if (digits.contains(num2 % 10)) {
                return true;
            }
            num2 /= 10;
        }
        return false;
    }
    
    /**
     * Calculates the modules of two numbers without using any inbuilt modulus
     * operator.
     * @param num1
     * @param num2
     * @return 
     */
    public static int modulo(int num1, int num2) {
        int diff = num2;
        while (diff < num1) {
            diff += num2;
        }
        return num1 + num2 - diff;
    }
    
    /**
     * Computes the sum of the first n prime numbers.
     * @param count
     * @return 
     */
    public static long sumOfPrimes(int count) {
        int i = 2;
        long sum = 0;
        while (count > 0) {
            if (isPrime(i)) {
                count--;
                sum += i;
                //System.out.println(i + "\t" + sum + "\t" + count);
            }
            i++;
        }
        return sum;
    }
    
    /**
     * Inserts a word in the middle of the another string.
     * @param source
     * @param insert
     * @return 
     */
    public static String stringInsert(String source, String insert) {
        String result = "";
        String[] srcArray = source.split(" ");
        int middleWord = srcArray.length / 2;
        for (int i = 0; i < srcArray.length; i++) {
            if (i == middleWord) {
                result += insert + " ";
            }
            result += srcArray[i] + " ";
        }
        return result.substring(0, result.length() - 1);
    }
    
    /**
     * Extracts the first or the second half of a string of even length.
     * @param source
     * @param first
     * @return 
     */
    public static String stringHalf(String source, boolean first) {
        return (first) ? source.substring(0, source.length() / 2)
                : source.substring(source.length() / 2);
    }
    
    /**
     * Creates a new string taking first three characters from a given string.
     * If the length of the given string is less than 3 uses "#" as substitute
     * characters.
     * @param source
     * @return 
     */
    public static String firstThreeChars(String source) {
        String result = "";
        final String SUB = "#";
        for (int i = 0; i < 3; i++) {
            if (i < source.length()) {
                result += source.charAt(i);
            } else {
                result += SUB;
            }
        }
        return result;
    }
    
    /**
     * Tests if num appears as either the first or last element of an array of
     * integers. The length of the array must be greater than or equal to 2.
     * @param source
     * @param num
     * @return 
     */
    public static boolean arrayFirstLastTest(int[] source, int num) {
        if (source.length < 2) {
            return false;
        }
        return source[0] == num || source[source.length -1] == num;
    }
    
    /**
     * Tests if the first and the last element of an array of integers are same.
     * The length of the array must be greater than or equal to 2.
     * @param source
     * @return 
     */
    public static boolean arrayFirstLastTest(int[] source) {
        if (source.length < 2) {
            return false;
        }
        return source[0] == source[source.length - 1];
    }
    
    /**
     * Tests if the first and the last element of two array of integers are
     * the same. The length of the array must be greater than or equal to 2.
     * @param arr1
     * @param arr2
     * @return 
     */
    public static boolean arrayFirstLastTest(int[] arr1, int[] arr2) {
        if (arr1.length < 2 || arr2.length < 2) {
            return false;
        }
        return arr1[0] == arr2[0] 
                && arr1[arr1.length - 1] == arr2[arr2.length -1];
    }
    
    /**
     * Tests if the given array of integers contains the given element.
     * @param source
     * @param elem
     * @return 
     */
    public static boolean arrayContains(int[] source, int elem) {
        for (int num : source) {
            if (num == elem) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Rotates an array (min. length 3) of integers in right or left direction.
     * @param source
     * @param right
     * @return 
     */
    public static int[] arrayRotate(int[] source, boolean right) {
        int[] result = new int[source.length];
        int i = right ? 1 : 0;
        int max = right ? source.length : source.length - 1;
        if (right) {
            result[0] = source[source.length - 1];
        } else {
            result[result.length - 1] = source[0];
        }
        for (; i < max; i++) {
            result[i] = right ? source[i - 1] : source[i + 1];
        }
        return result;
    }
    
    /**
     * Gets the largest value of an array of integers.
     * @param array
     * @return 
     */
    public static int arrayMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(i, max);
        }
        return max;
    }
    
    /**
     * Swaps the first and last elements of an array (length must be at least 1)
     * and create a new array.
     * @param source 
     * @return  
     */
    public static int[] arraySwapFirstLast(int[] source) {
        if (source.length < 2) {
            return source;
        }
        int[] result = Arrays.copyOf(source, source.length);
        result[0] = source[source.length - 1];
        result[result.length - 1] = source[0];
        return result;
    }
    
    /**
     * Multiplies corresponding elements of two arrays of integers.
     * @param arr1
     * @param arr2
     * @return 
     */
    public static int[] arraysMultiply(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return new int[]{};
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] * arr2[i];
        }
        return result;
    }
    
    /**
     * Counts the number of even and odd elements in a given array of integers.
     * @param source
     * @return 
     */
    public static Map<String, Integer> arrayEvenOdd(int[] source) {
        Map<String, Integer> result = new HashMap<>(2);
        result.put("Even", 0);
        result.put("Odd", 0);
        for (int elem : source) {
            if (elem % 2 == 0) {
                result.put("Even", result.get("Even") + 1);
            } else {
                result.put("Odd", result.get("Odd") + 1);
            }
        }
        return result;
    }
    
    /**
     * Tests if an array of integers contains an element XX next to XX or an
     * element YY next to YY, but not both.
     * @param source
     * @param xx
     * @param yy
     * @return 
     */
    public static boolean arrayXXYY(int[] source, int xx, int yy) {
        boolean foundXX = false;
        boolean foundYY = false;
        for (int i = 0; i < source.length - 1; i++) {
            if (source[i] == xx && source[i + 1] == xx) {
                foundXX = true;
            }
            if (source[i] == yy && source[i + 1] == yy) {
                foundYY = true;
            }
        }
        return foundXX != foundYY;
    }
    
    /**
     * Rearranges all the elements of a given array of integers so that all the
     * odd numbers come before all the even numbers.
     * @param array 
     * @return  
     */
    public static int[] arraySortOddEven(int[] array) {
        int[] result = new int[array.length];
        int oddIndex = 0;
        int evenIndex = arrayEvenOdd(array).get("Odd") - 1;
        for (int elem : array) {
            if (elem % 2 != 0) {
                result[oddIndex++] = elem;
            } else {
                result[evenIndex++] = elem;
            }
        }
        return result;
    }
    
    /**
     * Creates an array of string values. The elements will contain "0", "1",
     * "2" … through ... n-1.
     * @param num
     * @return 
     */
    public static String[] arrayFillStr(int num) {
        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            result[i] = String.valueOf(i);
        }
        return result;
    }
    
    /**
     * Checks if there is an XX in a given array of integers with a YY
     * somewhere later in the array.
     * @param array
     * @param xx
     * @param yy
     * @return 
     */
    public static boolean arrayXXBeforeYY(int[] array, int xx, int yy) {
        boolean foundXX = false;
        boolean foundYY = false;
        for (int elem : array) {
            if (elem == xx) {
                foundXX = true;
            }
            if (foundXX && elem == yy) {
                foundYY = true;
            }
        }
        return foundXX && foundYY;
    }
    
    /**
     * Checks if an array of integers contains two same specified numbers 
     * next to each other
     * @param array
     * @param x
     * @return 
     */
    @Deprecated
    public static boolean arrayXX(int[] array, int x) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == x && array[i + 1] == x) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if an array of integers contains two same specified numbers
     * separated by dist elements.
     * @param array
     * @param x
     * @param dist
     * @return 
     */
    public static boolean arrayXYX(int[] array, int x, int dist) {
        for (int i = 0; i < array.length - (dist + 1); i++) {
            if (array[i] == x && array[i + dist + 1] == x) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the value num appears x times
     * @param array
     * @param num
     * @param times
     * @return 
     */
    public static boolean arrayCount(int[] array, int num, int times) {
        return arrayCount(array, num) == times;
    }
    
    /**
     * Checks if a specified number appears in every pair of adjacent element
     * of a given array of integers.
     * @param array
     * @param num
     * @return 
     */
    public static boolean arrayPairs(int[] array, int num) {
        for (int i = 0; i < array.length - 1; i += 2) {
            if (array[i] != num && array[i + 1] != num) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Counts the two elements differ by diff or less of two given arrays of
     * integers.
     * @param arr1
     * @param arr2
     * @param diff
     * @return 
     */
    public static int arrayCount(int[] arr1, int[] arr2, int diff) {
        int maxIndex = Math.min(arr1.length, arr2.length);
        int count = 0;
        for (int i = 0; i < maxIndex; i++) {
            count += (Math.abs(arr1[i] - arr2[i]) <= diff) ? 1 : 0;
        }
        return count;
    }
    
    /**
     * Counts the num in a given array of integers.
     * @param array
     * @param num
     * @return 
     */
    public static int arrayCount(int[] array, int num) {
        int count = 0;
        for (int elem : array) {
            count += elem == num ? 1 : 0;
        }
        return count;
    }
    
    /**
     * Checks if the number of greater is greater than number to lower in a
     * given array of integers.
     * @param array
     * @param greater
     * @param lower
     * @param equal
     * @return 
     */
    public static boolean arrayCount(int[] array, int greater, int lower,
            boolean equal) {
        if (equal) {
            return arrayCount(array, greater) >= arrayCount(array, lower);
        }
        return arrayCount(array, greater) > arrayCount(array, lower);
    }
    
    /**
     * Creates a new array from a given array of integers, new array will
     * contain the elements from the given array after the last or 
     * before the first element value of limit.
     * @param source
     * @param limit
     * @param last
     * @return 
     */
    public static int[] arrayCreate(int[] source, int limit, boolean last) {
        int index = last ? source.length : -1;
        if (last) {
            while (source[--index] != limit) {
            }
        } else {
            while (source[++index] != limit) {
            }
        }
        int[] result = new int[limit];
        return Arrays.copyOfRange(source, last ? ++index : 0,
                last ? source.length : index);
    }
    
    /**
     * Checks if a group of numbers at the start and end of a given array are
     * the same. Order of the equality can be chosen.
     * @param array
     * @param size
     * @param order
     * @return 
     */
    public static boolean arrayCount(int[] array, int size, boolean order) {
        int[] subArray = order ? Arrays.copyOf(array, size)
                : arrayReverse(Arrays.copyOf(array, size));
        for (int i = array.length - size, j = 0; i < array.length; i++, j++) {
            if (array[i] != subArray[j]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks if an array of integers contains size increasing or decreasing
     * adjacent numbers.
     * @param array
     * @param size
     * @param diff
     * @param inc
     * @return 
     */
    public static boolean arrayContains(int[] array, int size, int diff, 
            boolean inc) {
        int maxSize = 0;
        int actSize = 1;
        for (int i = 0; i < array.length - 1; i++) {
            int higher = inc ? array[i + 1] : array[i];
            int lower = inc ? array[i] : array[i + 1];
            if (higher > lower && higher - lower <= diff) {
                actSize++;
            } else {
                maxSize = Math.max(maxSize, actSize);
                actSize = 1;
            }
        }
        maxSize = Math.max(maxSize, actSize);
        return maxSize >= size;
    }
    
    /**
     * Adds all the digits of a given positive integer until the result has a
     * single digit.
     * @param num
     * @return 
     */
    public static byte digitsValue(long num) {
        while (num / 10 != 0) {
            num = sumDigits(num);
        }
        return (byte) num;
    }
    
    /**
     * Forms a staircase shape of n coins where every k-th row must have exactly
     * k coins. Returns the number of rows.
     * @param num
     * @return 
     */
    public static int straircaseShape(long num) {
        if (num > 0) {
            return ((int) ((Math.sqrt(8 * num + 1) - 1) / 2));
        }
        else return (int) num;
    }
    
    /**
     * Checks whether a given integer is a power of base or not.
     * @param num
     * @param base
     * @return 
     */
    public static boolean isPowerOf(int num, int base) {
        int power = 1;
        while (power < num) {
            power *= base;
        }
        return power == num;
    }
    
    /**
     * Computes the number of trailing zeros in a factorial. 
     * @param base
     * @return 
     */
    public static int facorialTrailZero(int base) {
        long fact = factorial(base);
        int count = 0;
        while (fact != 0) {
            if (fact % 10 == 0) {
                count++;
            } else {
                break;
            }
            fact /= 10;
        }
        return count;
    }
    
    /**
     * Merges two given sorted array of integers and creates a new sorted array.
     * @param arr1
     * @param arr2
     * @return 
     */
    public static int[] arrayMerge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0, j = 0, k = 0; i < result.length; i++) {
            if (j < arr1.length) {
                if (k < arr1.length) {
                    if (arr1[j] < arr2[k]) {
                        result[i] = arr1[j++];
                    } else {
                        result[i] = arr2[k++];
                    }
                } else {
                    result[i] = arr1[j++];
                }
            } else {
                result[i] = arr2[k++];
            }
        }
        return result;
    }
    
    /**
     * Given a string and an offset, rotates the string by offset from left to
     * right.
     * @param str
     * @param offset
     * @return 
     */
    public static String stringRotate(String str, int offset) {
        char[] A = str.toCharArray();
        int len = A.length;
        offset %= len;
        reverse(A, 0, len - offset - 1);
        reverse(A, len - offset, len - 1);
        reverse(A, 0, len - 1);
        return Arrays.toString(A);
    }
    
    /**
     * Checks if a positive number is a palindrome or not.
     * @param num
     * @return 
     */
    public static boolean isPalindrome(int num) {
        String numStr = Integer.toString(num);
        return numStr.equals(reverseString(numStr));
    }
    
    /**
     * Computes the square root of a given integer.
     * @param num
     * @return 
     */
    public static int squareRoot(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int a = 0;
        int b = num;
        while (a <= b) {
            int mid = (a + b) >> 1;
            if (num / mid < mid) {
                b = mid - 1;
            } else {
                if (num / (mid + 1) <= mid) {
                    return mid;
                }
                a = mid + 1;
            }
        }
        return a;
	}
    
    /**
     * Converts an array of binary values to a string.
     * @param array
     * @return 
     */
    @Deprecated
    private static String arrayToString(int[] array) {
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        return result.substring(result.indexOf("1"), result.length());
    }

    /**
     * Converts a List of integer values to a string.
     * @param numbers
     * @param numSystem
     * @return 
     */
    private static String listToString(List<Integer> numbers, int numSystem) {
        String result = "";
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int num = numbers.get(i);
            if (num < 10) {
                result += num;
            } else {
                result += (char) (num + 55);
            }
        }
        return result;
    }

    /**
     * Takes in an integer (it can be either positive or negative) and
     * returns True when it is a prime and False otherwise
     * @param num
     * @return 
     */
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the source array of integers in reverse form.
     * @param nums
     * @return 
     */
    public static int[] arrayReverse(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[result.length - i - 1] = nums[i];
        }
        return result;
    }
    
    /**
     * Returns the source string in reverse form.
     * @param str
     * @param start
     * @param end 
     */
    public static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
     * (n-2) ... 1. Compute the result recursively (without loops).
     * @param n
     * @return 
     */
    public static int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
    
    /**
     * Prints an American flag on the screen. 
     */
    public static class Flag {
        
        private static final String UPPER_LINES = 
                "* * * * * * ==================================\n" + 
                " * * * * * ===================================";
        private static final String LOWER_LINES = 
                "==============================================";
        
        public static void drawFlag () {
            for (int i = 0; i < 4; i++) {
                System.out.println(UPPER_LINES);
            }
            System.out.println(
                UPPER_LINES.substring(0, UPPER_LINES.indexOf("\n")));
            for (int i = 0; i < 6; i++) {
                System.out.println(LOWER_LINES);
            }
        }
    }
    
    /**
     * To check whether Java is installed on your computer.
     */
    public static class SystemProperties {
        private static final String VERSION = 
                System.getProperty("java.version");
        private static final String RUNTIME = 
                System.getProperty("java.runtime.version");
        private static final String JAVA_HOME =
                System.getProperty("java.home");
        private static final String VENDOR =
                "Oracle Corporation";
        private static final String VENDOR_URL =
                "http://Java.oracle.com/";
        private static final String CLASS_PATH =
                System.getProperty("java.class.path");
        private static final Map<String, String> SYS_ENV = System.getenv();
        private static final Properties SYS_PROP = System.getProperties();
        private static final SecurityManager SECU_MAN = 
                System.getSecurityManager();
        private static final String PATH = System.getenv("PATH");
        private static final String TEMP = System.getenv("TEMP");
        private static final String USER = System.getenv("USERNAME");
        
        public static String javaProperties() {
            return "Java Version: " + VERSION + "\n" +
                    "Java Runtime Version: " + RUNTIME + "\n" +
                    "Java Home: " + JAVA_HOME + "\n" +
                    "Java Vendor: " + VENDOR + "\n" +
                    "Java Vendor URL: " + VENDOR_URL + "\n" +
                    "Java Class Path: " + CLASS_PATH + "\n";
        }
    }

    public static class Coordinate {
        
        private double latitude;
        private double longitude;

        public Coordinate() {}

        public Coordinate(double latitude, double longitude) {
            this.latitude = Math.toRadians(latitude);
            this.longitude = Math.toRadians(longitude);
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = Math.toRadians(latitude);
        }

        public void setLongitude(double longitude) {
            this.longitude = Math.toRadians(longitude);
        }
    }
}