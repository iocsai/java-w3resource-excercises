package w3resource;

import java.util.TreeMap;
import org.apache.commons.lang3.tuple.*;

/**
 * Amicable numbers are two different numbers so related that the sum of the
 * proper divisors of each is equal to the other number.
 *
 * @author Ócsai István
 */
public class AmicableNumbers extends NumberMethods {

    private static final int LOWEST_AMICABLE_NUMBER = 220;

    private final Pair amicablePair;

    public AmicableNumbers() {
        this.amicablePair = Pair.of(LOWEST_AMICABLE_NUMBER,
                getProperDivisorSum(LOWEST_AMICABLE_NUMBER));
    }

    public AmicableNumbers(Pair<Integer, Integer> amicablePair) {
        if (isAmicablePair(amicablePair.getLeft(), amicablePair.getRight())) {
            this.amicablePair = amicablePair;
        } else {
            this.amicablePair = Pair.of(LOWEST_AMICABLE_NUMBER,
                    getProperDivisorSum(LOWEST_AMICABLE_NUMBER));
        }
    }

    public Pair getAmicablePair() {
        return this.amicablePair;
    }

    /**
     * To check two numbers are Amicable numbers or not.
     *
     * @param num1
     * @param num2
     * @return
     */
    public static boolean isAmicablePair(int num1, int num2) {
        int num1SumDivisors = getProperDivisorSum(num1);
        int num2SumDivisors = getProperDivisorSum(num2);
        return num1 != num2
                && num1SumDivisors == num2 && num2SumDivisors == num1;
    }

    /**
     * To get Amicable pairs. The first 10 amicable pairs are: (220, 284),
     * (1184, 1210), (2620, 2924), (5020, 5564), (6232, 6368), (10744, 10856),
     * (12285, 14595), (17296, 18416), (63020, 76084), and (66928, 66992).
     *
     * @param amount
     * @return
     */
    public static TreeMap<Integer, Integer> getAmicablePairs(int amount) {
        TreeMap<Integer, Integer> result = new TreeMap<>();
        int num1 = LOWEST_AMICABLE_NUMBER;
        while (result.size() < amount) {
            int num1DivisorSum = getProperDivisorSum(num1);
            if (isAmicablePair(num1, num1DivisorSum)
                    && !result.containsKey(num1DivisorSum)) {
                result.put(num1, num1DivisorSum);
            }
            num1++;
        }
        return result;
    }

    /**
     * Returns the amount of all amicable numbers lower than max
     *
     * @param max
     * @return
     */
    public static int getAmicableAmount(int max) {
        int sum = 0;
        for (int i = LOWEST_AMICABLE_NUMBER; i < max; i++) {
            int a = getProperDivisorSum(i);
            if (isAmicablePair(i, a)) {
                sum++;
            }
        }
        return sum / 2;
    }

    /**
     * To get the sum of the divisors of an integer.
     *
     * @param number
     * @return
     */
    public static int getProperDivisorSum(int number) {
        return NumberMethods.listSum(NumberMethods.getDivisors(number, true))
                - number;
    }
}
