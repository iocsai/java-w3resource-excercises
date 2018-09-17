package w3resource;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;

/**
 * https://www.w3resource.com/java-exercises/numbers/index.php
 *
 * @author Ócsai István
 */
public class NumberMethods {
    
    private static final int LOWEST_FERMAT = 3; 
    
    /**
     * To get nth pentagonal number.
     * @param n
     * @return 
     */
    public static int nthPentagonalNumber(int n) {
        return (n * (3 * n - 1))/2;
    }
    
    /**
     * To get the first n pentagonal numbers
     * @param count
     * @return 
     */
    public static List<Integer> getPentagonalNumbers(int count) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            result.add(nthPentagonalNumber(i));
        }
        return result;
    }
    
    /**
     * To compute the future investment value at a given interest rate for a
     * specified number of years.
     * @param investmentAmount
     * @param monthlyInterestRate
     * @param years
     * @return 
     */
    public static Map<Integer, Double> futureInvestmentValue(
            double investmentAmount, double monthlyInterestRate, int years) {
        Map<Integer, Double> result = new HashMap<>();
        result.put(0, investmentAmount);
        for (int i = 1; i <= years; i++) {
            double newAmount = investmentAmount * // result.get(i - 1)
                    Math.pow(1 + monthlyInterestRate, i * 12);
            result.put(i, newAmount);
        }
        return result;
    }
    
    /**
     * To check whether a given number is an ugly number. Ugly numbers are
     * positive numbers whose only prime factors are 2, 3 or 5.
     * First 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12.
     * By convention, 1 is included. 
     * @param number
     * @return 
     */
    public static boolean isUglyNumber(int number) {
        if (Basic.isPrime(number) && number > 5) {
            return false;
        }
        for(int i = 2; i <= (number / 2); i++) {
            if (Basic.isPrime(i) && number % i == 0 && i > 5) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * To get Ugly numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getUglyNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isUglyNumber(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To get a number's divisors.
     * @param number
     * @param all
     * @return 
     */
    public static List<Integer> getDivisors(int number, boolean all) {
        List<Integer> result = new ArrayList<>();
        if (all) {
            result.add(1);
            result.add(number);
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                result.add(i);
                result.add(number / i);
            }
        }
        result.sort((Integer num1, Integer num2) -> num1.compareTo(num2));
        return result.stream().distinct().collect(Collectors.toList());
    }
    
    /**
     * To classify abundant number. In number theory, an abundant number is a
     * number for which the sum of its proper divisors is greater than the
     * number itself.
     * @param number 
     * @return  
     */
    public static boolean isAbundant(int number) {
        List<Integer> divisors = getDivisors(number, false);
        int sumDivisors = 1;
        int index = 0;
        /*sumDivisors = divisors.stream().map((divisor) -> divisor)
                .reduce(sumDivisors, Integer::sum);*/
        while (sumDivisors <= number && index < divisors.size()) {
            sumDivisors += divisors.get(index++);
        }
        return sumDivisors > number;
    }
    
    /**
     * To get Abundant numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getAbundantNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isAbundant(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To check if the number is deficient. In number theory, a deficient
     * number is a number n for which the sum of divisors σ(n) < 2n, or, 
     * equivalently, the sum of proper divisors (or aliquot sum) s(n) < n.
     * The value 2n − σ(n) (or n − s(n)) is called the number's deficiency.
     * As an example, divisors of 21 are 1, 3 and 7, and their sum is 11.
     * Because 11 is less than 21, the number 21 is deficient. Its deficiency
     * is 2 × 21 − 32 = 10.
     * @param number
     * @return 
     */
    public static boolean isDeficient(int number) {
        return getDeficiency(number) > 0;
    }
    
    /**
     * To get a number's deficiency.
     * @param number
     * @return 
     */
    public static int getDeficiency(int number) {
        List<Integer> divisors = getDivisors(number, true);
        int sumDivisors = 0;
        sumDivisors = divisors.stream().map((divisor) -> divisor)
                .reduce(sumDivisors, Integer::sum);
        return 2 * number - sumDivisors;
    }
    
    /**
     * To get Deficient numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getDeficientNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isDeficient(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * Perfect number: In number system, a perfect number is a positive integer
     * that is equal to the sum of its proper positive divisors, that is, the
     * sum of its positive divisors excluding the number itself. Equivalently,
     * a perfect number is a number that is half the sum of all of its positive
     * divisors (including itself) i.e. σ(n) = 2n.
     * @param number
     * @return 
     */
    public static boolean isPefect(int number) {
        List<Integer> divisors = getDivisors(number, true);
        int sumDivisors = 0;
        sumDivisors = divisors.stream().map((divisor) -> divisor)
                .reduce(sumDivisors, Integer::sum);
        return 2 * number == sumDivisors;
    }
    
    /**
     * To get Pefect numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getPefectNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isPefect(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * In number theory, a Kaprekar number for a given base is a non-negative
     * integer, the representation of whose square in that base can be split
     * into two parts that add up to the original number again. For instance,
     * 45 is a Kaprekar number, because 45^2 = 2025 and 20 + 25 = 45. 
     * @param number
     * @return 
     */
    public static boolean isKaprekar(int number) {
        int square = (int) Math.pow(number, 2);
        String squareStr = String.valueOf(square);
        if (squareStr.length() % 2 == 1) {
            squareStr = "0" + squareStr;
        }
        int firstHalf = Integer.parseInt(
                squareStr.substring(0, squareStr.length() / 2));
        int lastHalf = Integer.parseInt(
                squareStr.substring(squareStr.length() / 2));
        return number == firstHalf + lastHalf;
    }
    
    /**
     * To get Kaprekar numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getKaprekarNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isKaprekar(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To get Lychrel numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getLychrelNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isLychrel(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * Decides if a given number is Lychrel number. A Lychrel number is a
     * natural number that cannot form a palindrome through the iterative
     * process of repeatedly reversing its digits and adding the resulting
     * numbers. This process is sometimes called the 196-algorithm, after the
     * most famous number associated with the process.
     * @param number
     * @param iterationLimit
     * @return 
     */
    public static boolean isLychrel(int number, int iterationLimit) {
        return lychrel(number, iterationLimit).flag;
    }
    
    /**
     * Decides if a given number is Lychrel number. A Lychrel number is a
     * natural number that cannot form a palindrome through the iterative
     * process of repeatedly reversing its digits and adding the resulting
     * numbers. This process is sometimes called the 196-algorithm, after the
     * most famous number associated with the process.
     * @param number
     * @return 
     */
    public static boolean isLychrel(int number) {
        return lychrel(number, 500).flag;
    }
    
    /**
     * To decide if a number is Lycrel or not.
     * @param number
     * @param iterationLimit
     * @return 
     */
    private static Tuple lychrel(int number, int iterationLimit) {
        Map<BigInteger, Tuple> cache = new HashMap<>();
        BigInteger num = BigInteger.valueOf(number);
        BigInteger rev = reverseNumber(num);
        Tuple result = new Tuple(true, num);
        List<BigInteger> seen = new ArrayList<>();
        for (int i = 0; i < iterationLimit; i++) {
            num = num.add(rev);
            rev = reverseNumber(num);
            if (num.equals(rev)) {
                result = new Tuple(false, BigInteger.ZERO);
                break;
            }
            if (cache.containsKey(num)) {
                result = cache.get(num);
                break;
            }
            seen.add(num);
        }
        for (BigInteger bi : seen) {
            cache.put(bi, result);
        }
        return result;
    }
    
    /**
     * To reverse an integer number.
     * @param number
     * @return 
     */
    public static BigInteger reverseNumber(BigInteger number) {
        String str = new StringBuilder(number.toString()).reverse().toString();
        return new BigInteger(str);
    }

    /**
     * A class for Lychrel numbers.
     */
    private static class Tuple {

        final Boolean flag;
        final BigInteger bi;

        public Tuple(Boolean flag, BigInteger bi) {
            this.flag = flag;
            this.bi = bi;
        }
    }
    
    /**
     * A Narcissistic decimal number is a non-negative integer, n that is equal
     * to the sum of the m-th powers of each of the digits in the decimal
     * representation of n, where m is the number of digits in the decimal
     * representation of n.
     * Ex: if n is 153 then m, (the number of decimal digits) is 3, 
     * we have 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
     * and so 153 is a narcissistic decimal number.
     * @param number
     * @return 
     */
    public static boolean isNarcissistic(int number) {
        List<Integer> digits = digitsNumber(number);
        int exponent = digits.size();
        return number == powerAmount(digits, exponent);
    }
    
    /**
     * To get Narcissistic numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getNarcissisticNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isNarcissistic(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To receive the digits of a number.
     * @param number
     * @return 
     */
    public static List<Integer> digitsNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }
    
    /**
     * To get the nums amount of power.
     * @param nums
     * @param exponent
     * @return 
     */
    public static int powerAmount(List<Integer> nums, int exponent) {
        int sum = 0;
        sum = nums.stream().map((num) -> 
                (int) Math.pow(num, exponent)).reduce(sum, Integer::sum);
        return sum;
    }
    
    /**
     * To display an amuont of Lucas numbers. The Lucas numbers or series are
     * an integer sequence named after the mathematician François Édouard
     * Anatole Lucas, who studied both that sequence and the closely related
     * Fibonacci numbers. Lucas numbers and Fibonacci numbers form
     * complementary instances of Lucas sequences.
     * The sequence of Lucas numbers is: 2, 1, 3, 4, 7, 11, 18, 29, ….
     * @param amount
     * @return 
     */
    public static List<Integer> getLucasNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(1);
        for (int i = 2; i < amount; i++) {
            result.add(result.get(i - 2) + result.get(i - 1));
        }
        return result;
    }
    
    /**
     * To get specific numbers.
     * @param amount
     * @param is
     * @return 
     * @throws java.lang.IllegalAccessException 
     * @throws java.lang.reflect.InvocationTargetException 
     */
    public static List<Integer> getNumbers(int amount, Method is) 
            throws IllegalAccessException, 
            IllegalArgumentException, 
            InvocationTargetException {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (Boolean.parseBoolean(is.invoke(null, number).toString())) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To find that a number is a happy number. Happy number: Starting with any
     * positive integer, replace the number by the sum of the squares of its
     * digits, and repeat the process until the number equals 1, or it loops
     * endlessly in a cycle which does not include 1.
     * @param number
     * @return 
     */
    public static boolean isHappyNumber(int number) {
        HashSet<Integer> holder = new HashSet();
        while (number != 1 && holder.add(number)) {
            System.out.println(number + "\t" + holder.size());
            number = powerAmount(digitsNumber(number), 2);
        }
        return number == 1;
    }
    
    /**
     * To get happy numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getHappyNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isHappyNumber(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To check whether a given number is a Disarium number. A number will be
     * called Disarium if the sum of its digits powered with their respective
     * position is equal with the number itself. 
     * @param number
     * @return 
     */
    public static boolean isDisarium(int number) {
        List<Integer> digits = digitsNumber(number);
        int sum = 0;
        sum = digits.stream().map((num) -> 
                (int) Math.pow(num, digits.size() - digits.indexOf(num)))
                .reduce(sum, Integer::sum);
        return sum == number;
    }
    
    /**
     * To get Disarium numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getDisariumNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isDisarium(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To check whether a number is a Harshad Number or not. In recreational
     * mathematics, a harshad number in a given number base, is an integer
     * that is divisible by the sum of its digits when written in that base.
     * Example: Number 200 is a Harshad Number because the sum of digits 2
     * and 0 and 0 is 2 (2+0+0) and 200 is divisible by 2.
     * Number 171 is a Harshad Number because the sum of digits 1 and 7 and 1
     * is 9 (1+7+1) and 171 is divisible by 9.
     * @param number
     * @return 
     */
    public static boolean isHarshard(int number) {
        int sum = listSum(digitsNumber(number));
        return number % sum == 0;
    }
    
    /**
     * To get Harshard numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getHarshardNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 1;
        while (amount > 0) {
            if (isHarshard(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * Calculates the sum of a List of integers.
     * @param nums
     * @return 
     */
    public static int listSum(List<Integer> nums) {
        int sum = 0;
        sum = nums.stream().map((num) -> num).reduce(sum, Integer::sum);
        return sum;
    }
    
    /**
     * To check whether a number is a Pronic Number or Heteromecic Number or not.
     * A pronic number is a number which is the product of two consecutive
     * integers, that is, a number of the form n * (n + 1).
     * @param number
     * @return 
     */
    public static boolean isPronic(int number) {
        int i = (int) Math.sqrt(number) + 1;
        return i * (i + 1) == number;
    }
    
    /**
     * To get Pronic numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getPronicNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isPronic(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To check whether a number is an Automorphic number or not. In
     * mathematics, an automorphic number is a number whose square "ends" in
     * the same digits as the number itself.
     * @param number
     * @return 
     */
    public static boolean isAutomorphic(int number) {
        long square = (long) Math.pow(number, 2);
        String numberStr = Integer.toString(number);
        String squareStr = Long.toString(square);
        return squareStr.endsWith(numberStr);
    }
    
    /**
     * To get automorphic numbers.
     * @param amount
     * @return 
     */
    public static List<Integer> getAutomorphicNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 0;
        while (amount > 0) {
            if (isAutomorphic(number)) {
                result.add(number);
                amount--;
            }
            number++;
        }
        return result;
    }
    
    /**
     * To check whether a number is a Duck Number or not. A Duck number is a
     * number which has zeroes present in it, but there should be no zero
     * present in the beginning of the number. For example 3210, 7056, 8430709
     * are all duck numbers whereas 08237, 04309 are not.
     * @param number
     * @return 
     */
    public static boolean isDuckNumber(String number) {
        String modified = String.valueOf(Integer.parseInt(number));
        return number.equals(modified) && number.contains("0");        
    }
    
    /**
     * To check if a given number is circular prime or not. 
     * Circular Prime : A circular prime is a prime number with the property 
     * that the number generated at each intermediate step when cyclically 
     * permuting its (base 10) digits will be prime. 
     * For example, 1193 is a circular prime, since 1931, 9311 and 3119 all are
     * also prime. A circular prime with at least two digits can only consist 
     * of combinations of the digits 1, 3, 7 or 9, because having 0, 2, 4, 6 
     * or 8 as the last digit makes the number divisible by 2, and having 0 or
     * 5 as the last digit makes it divisible by 5.
     * @param number
     * @return 
     */
    public static boolean isCyclicPrime(int number) {
        List<Integer> digits = digitsNumber(number);
        if (isPrime(number)
                && (!digits.contains(0) 
                || !digits.contains(2) 
                || !digits.contains(4)
                || !digits.contains(5) 
                || !digits.contains(6) 
                || !digits.contains(8))
                ) {
            boolean allPrime = true;
            digits.add(digits.get(0));
            digits.remove(0);
            String numStr = "";
            for (int i = digits.size() - 1; i >= 0; i--) {
                numStr += digits.get(i);
            }
            allPrime = allPrime && isPrime(Integer.parseInt(numStr));
            return allPrime;
        }
        return false;
    }
    
    /**
     * To check if n is a prime number.
     * @param number
     * @return 
     */
    public static boolean isPrime(int number) {
        //check if n equals 2
        if (number == 2) return true;
        //check if n is lower than 2 or a multiple of 2
        if (number < 2 || number % 2 == 0) return false;
        //if not, then just check the odds
        for(int i = 3; i * i <= number; i += 2) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
    
    /**
     * To check a number is a cube or not.
     * @param number
     * @return 
     */
    public static boolean isCube(int number) {
        return Math.cbrt((double) number) == (int) Math.cbrt((double) number);
    }
    
    /**
     * To check a number is a cyclic or not. A cyclic number is an integer in
     * which cyclic permutations of the digits are successive multiples of the
     * number. The most widely known are 142857:
     * 142857 × 1 = 142857
     * 142857 × 2 = 285714
     * 142857 × 3 = 428571
     * 142857 × 4 = 571428
     * 142857 × 5 = 714285
     * 142857 × 6 = 857142
     * @param number
     * @return 
     */
    public static boolean isCyclic(int number) {
        int shifted = number;
        for (int i = 1; i < amountDigit(number); i++) {
            shifted = shiftRight(shifted);
            if ((shifted > number && shifted % number != 0)
                    || (shifted <= number && number % shifted != 0)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Shifts an integer digits right.
     * @param number
     * @return 
     */
    public static int shiftRight(int number) {
        return number / 10 + number % 10 * 
                (int) Math.pow(10, amountDigit(number) - 1);
    }
    
    /**
     * Returns the number of the digits in an int number.
     * @param number
     * @return 
     */
    public static int amountDigit(int number) {
        int result = 0;
        while (number > 0) {
            result++;
            number /= 10;
        }
        return result;
    }
    
    /**
     * To check a number is a Fermat-number or not. A Fermat number is a 
     * positive integer of the form 
     * F<sub>n</sub> = (F<sub>n-1</sub> - 1)<sup>2</sup> + 1.
     * @param number
     * @return 
     */
    public static boolean isFermat(long number) {
        long fermat = LOWEST_FERMAT;
        while (fermat <= number) {
            if (fermat == number) {
                return true;
            }
            fermat = (long) (Math.pow(fermat - 1, 2) + 1);
        }
        return false;
    }
    
    /**
     * To display the first <i>n</i> Fermat-numbers. A Fermat number is a 
     * positive integer of the form 
     * F<sub>n</sub> = (F<sub>n-1</sub> - 1)<sup>2</sup> + 1.
     * @param amount
     * @return 
     */
    public static List<Double> getFermatNumbers(int amount) {
        List<Double> result = new ArrayList<>();
        result.add(Double.valueOf(Integer.toString(LOWEST_FERMAT)));
        for (int i = 0; i < amount; i++) {
            result.add(Math.pow(result.get(i) - 1, 2) + 1);
        }
        return result;
    }
    
    /**
     * To check a number is a Ramanujan-number or not, a number that can be
     * expressed as the sum of two cubes in two (or more) different ways.
     * @param number
     * @return 
     */
    public static boolean isRamanujan(int number) {
        //Math.cbrt(number)
        int cuberoots = 0;
        int maxi = (int) Math.cbrt(number - 1);
        for (int i = 1; i < maxi; i++) {
            double probe = Math.cbrt(number - Math.pow(i, 3));
            if (probe == (int) probe) {
                cuberoots++;
                //System.out.println(cuberoots + "\t" + i + "\t" + (int) probe);
                maxi = (int) probe;
            }
        }
        return cuberoots >= 2;
    }
    
    /**
     * To find any number between 1 and n that can be expressed as the sum of
     * two cubes in two (or more) different ways.
     * @param maxNum
     * @return 
     */
    public static String getRamanujan(int maxNum) {
        final String NL = "\n", CU = "^3", EQ = " = ", AD = " + ";
        String result = "";
        for (int i = 1; i < maxNum; i++) {
            if (isRamanujan(i)) {
                result += i + EQ;
                int maxi = (int) Math.cbrt(i - 1);
                for (int j = 1; j < maxi; j++) {
                    double probe = Math.cbrt(i - Math.pow(j, 3));
                    if (probe == (int) probe) {
                        maxi = (int) probe;
                        result += j + CU + AD + (int) probe + CU + EQ; 
                    }
                }
                result = result.substring(0, result.length() - 3) + NL;
            }
        }
        return result;
    }
    
    /**
     * To check if a number is Mersenne number or not. A Mersenne number is a 
     * prime number that can be written in the form 
     * M<sub>n</sub> = 2<sup>n</sup> − 1 for some integer n
     * @param number
     * @return 
     */
    public static boolean isMersenne(int number) {
        double log = Math.log10(number + 1) / Math.log10(2);
        return isPrime(number) && log == (int) log;
    }
    
    /**
     * To find Mersanne numbers number between <i>1</i> and <i>n</i>.
     * @param maxNum
     * @return 
     */
    public static List<Long> getMersenne(long maxNum) {
        List<Long> result = new ArrayList<>();
        double log = Math.log10(maxNum + 1) / Math.log10(2);
        for (long i = 1; i < log; i++) {
            if (isPrime((int) (Math.pow(2, i) - 1))) {
                result.add((long) Math.pow(2, i) - 1);
            }
        }
        return result;
    }
    
    /**
     * To check if a number is palindrome or not.
     * @param number
     * @return 
     */
    public static boolean isPalindrom(int number) {
        String numStr = Integer.toString(number);
        String revNum = "";
        for (int i = numStr.length() - 1; i >= 0; i--) {
            revNum += numStr.charAt(i);
        }
        return  numStr.equals(revNum); 
    }
    
    /**
     * To print the first <i>n</i> numbers of the Pell series. In mathematics, 
     * the Pell numbers are an infinite sequence of integers. The sequence of 
     * Pell numbers starts with 0 and 1, and then each Pell number is the sum 
     * of twice the previous Pell number and the Pell number before that.:
     * The first few terms of the sequence are:
     * 0, 1, 2, 5, 12, 29, 70, 169, 408, 985, 2378, 5741, 13860,…
     * @param amount
     * @return 
     */
    public static List<Long> getPellNumbers(int amount) {
        if (amount < 1) return null;
        List<Long> result = new ArrayList<>();
        result.add(Long.valueOf(0));
        if (amount < 2) return result;
        result.add(Long.valueOf(1));
        while (result.size() < amount) {
            result.add(result.get(result.size() - 2)
                    + result.get(result.size() - 1) * 2);
        }
        return result;
    }
    
    /**
     * To check whether a number is a Keith Number or not. A Keith number is an
     * <i>n</i>-digit integer <i>N > 9</i> such that if a Fibonacci-like 
     * sequence (in which each term in the sequence is the sum of the <i>n</i>
     * previous terms) is formed with the first <i>n</i> terms taken as the
     * decimal digits of the number <i>N</i>, then <i>N</i> itself occurs as a
     * term in the sequence. 
     * For example, 197 is a Keith number since it generates the sequence 1, 9, 7, 
     * 1 + 9 + 7 = 17, 
     * 9 + 7 + 17 = 33, 
     * 7 + 17 + 33 = 57, 
     * 17 + 33 + 57 = 107, 
     * 33 + 57 + 107 = 197, 
     * ... (Keith). 
     * Keith numbers are also called repfigit (repetitive fibonacci-like digit)
     * numbers. 
     * @param number
     * @return 
     */
    public static boolean isKeithNumber(int number) {
        if (number < 10) return false;
        int sum = 0;
        List<Integer> subTotal = digitsNumber(number);
        Collections.reverse(subTotal);
        while (sum < number) {
            sum = listSum(subTotal);
            subTotal.add(sum);
            subTotal.remove(0);
        }
        return sum == number;
    }
    
    /**
     * To check if a given number is circular prime or not. A circular prime is
     * a prime number with the property that the number generated at each
     * intermediate step when cyclically permuting its (base 10) digits will
     * be prime.
     * For example, 1193 is a circular prime, since 1931, 9311 and 3119 all
     * are also prime.
     * @param number
     * @return 
     */
    public static boolean isCircularPrime(int number) {
        if (!isPrime(number)) return false;
        List<Integer> digits = digitsNumber(number);
        if (digits.size() == 1) return isPrime(number);
        if (digits.contains(0) || digits.contains(2) || digits.contains(4)
                || digits.contains(5) || digits.contains(6)
                || digits.contains(8)) {
        return false;
        }
        for (int i = 0; i < digits.size(); i++) {
            int newNum = shiftRight(number);
            if (!isPrime(newNum)) return false;
        }
        return true;
    }
    
    /**
     * To check if a given number is Hamming number or not. In computer science,
     * regular numbers are often called Hamming numbers, Hamming Numbers are 
     * numbers whose only prime factors are <i>2, 3 and 5</i>.
     * @param number
     * @return 
     */
    public static boolean isHammingNumber(int number) {
        List<Integer> primeFactors = getPrimeFactors(number);
        //check if number is only divisable by 2, 3, 5
        return primeFactors.stream().allMatch((elem) 
                -> (elem == 2 || elem == 3 || elem == 5));
    }
    
    /**
     * To get a number's prime factors as a List of integers.
     * @param number
     * @return 
     */
    public static List<Integer> getPrimeFactors(int number) {
        List<Integer> divisors = getDivisors(number, true);
        List<Integer> result = new ArrayList<>();
        divisors.stream().filter((elem) 
                -> (isPrime(elem))).forEachOrdered((elem) 
                        -> {result.add(elem);
        });
        return result;
    }
    
    /**
     * To create the first <i>n</i> Hamming numbers. Hamming Numbers are 
     * numbers whose only prime factors are <i>2, 3 and 5</i>.
     * @param amount
     * @return 
     */
    public static List<Integer> getHammingNumbers(int amount) {
        List<Integer> result = new ArrayList<>();
        int number = 1;
        while (result.size() < amount) {
            if (isHammingNumber(number++)) {
                result.add(number - 1);
            }
        }
        return result;
    }
}