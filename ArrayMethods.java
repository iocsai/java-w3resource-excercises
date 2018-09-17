package w3resource;

import java.util.*;

/**
 * https://www.w3resource.com/java-exercises/array/index.php
 * 
 * @author Ócsai István
 */
public class ArrayMethods {
    
    /**
     * To sum values of an array.
     * @param source
     * @return 
     */
    public static int arraySum(int[] source) {
        int sum = 0;
        for (int elem : source) {
            sum += elem;
        }
        return sum;
    }
    
    /**
     * To calculate the average value of array elements.
     * @param source
     * @return 
     */
    public static double arrayAverage(int[] source) {
        return arraySum(source) / (double) source.length;
    }
    
    /**
     * To test if an array contains a specific value.
     * @param source
     * @param value
     * @return 
     */
    public static boolean arrayContains(int[] source, int value) {
        for (int elem : source) {
            if (elem == value) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * To find the index of an array element.
     * @param array
     * @param value
     * @return 
     */
    public static int arrayFirstIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * To remove a specific element from an array.
     * @param array
     * @param index 
     * @return  
     */
    public static int[] arrayRemoveIndex(int[] array, int index) {
        int[] temp = new int[array.length - 1];
        System.arraycopy(array, 0, temp, 0, index);
        for (int i = index; i < temp.length; i++) {
            temp[i] = array[i + 1];
        }
        return temp;
    }
    
    /**
     * To find the maximum value of an array.
     * @param array
     * @return 
     */
    public static int arrayMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int elem : array) {
            max = Math.max(max, elem);
        }
        return max;
    }
    
    /**
     * To find the minimum value of an array.
     * @param array
     * @return 
     */
    public static int arrayMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int elem : array) {
            min = Math.min(min, elem);
        }
        return min;
    }
    
    /**
     * To reverse an array of integer values.
     * @param array 
     */
    public static void arrayReverse(int[] array) {
        int[] temp = Arrays.copyOf(array, array.length);
        for (int i = 0; i < temp.length; i++) {
            array[array.length - i - 1] = temp[i];
        }
    }
    
    /**
     * To find the duplicate values of an array of integer values.
     * @param array
     * @return 
     */
    public static Integer[] arrayDuplicates(int[] array) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i != j && array[i] == array[j]
                        && !duplicates.contains(array[i])) {
                    duplicates.add(array[i]);
                }
            }
        }
        return duplicates.toArray(new Integer[duplicates.size()]);
    }
    
    /**
     * To find the duplicate values of an array of string values.
     * @param array
     * @return 
     */
    public static String[] arrayDuplicates(String[] array) {
        List<String> duplicates = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i != j && array[i].equals(array[j])
                        && !duplicates.contains(array[i])) {
                    duplicates.add(array[i]);
                }
            }
        }
        return duplicates.toArray(new String[duplicates.size()]);
    }
    
    /**
     * To find the common elements between two arrays of integers.
     * @param arr1
     * @param arr2
     * @return 
     */
    public static Integer[] arrayCommonElements(int[] arr1, int[] arr2) {
        List<Integer> commonElems = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && !commonElems.contains(arr1[i])) {
                    commonElems.add(arr1[i]);
                }
            }
        }
        return commonElems.toArray(new Integer[commonElems.size()]);
    }
    
    /**
     * To find the common elements between two arrays of sstrings.
     * @param arr1
     * @param arr2
     * @return 
     */
    public static String[] arrayCommonElements(String[] arr1, String[] arr2) {
        List<String> commonElems = new ArrayList<>();
        for (String arr1Elem : arr1) {
            for (String arr2Elem : arr2) {
                if (arr1Elem.equals(arr2Elem) 
                        && !commonElems.contains(arr1Elem)) {
                    commonElems.add(arr1Elem);
                }
            }
        }
        return commonElems.toArray(new String[commonElems.size()]);
    }
    
    /**
     * To remove duplicate elements from an array of integers.
     * @param array
     * @return 
     */
    public static Integer[] arrayRemoveDuplicates(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int elem : array) {
            if (!result.contains(elem)) {
                result.add(elem);
            }
        }
        return result.toArray(new Integer[result.size()]);
    }
    
    /**
     * To find the Nth largest element in an array of integers.
     * @param array
     * @param nth
     * @return 
     */
    public static int arrayFindNthLargest(int[] array, int nth) {
        if (nth < 1 || nth > array.length - 1) {
            return Integer.MAX_VALUE;
        }
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        return sorted[sorted.length - nth];
    }
    
    /**
     * To find the Nth smallest element in an array of integers.
     * @param array
     * @param nth
     * @return 
     */
    public static int arrayFindNthSmallest(int[] array, int nth) {
        if (nth < 1 || nth > array.length - 1) {
            return Integer.MIN_VALUE;
        }
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        return sorted[nth - 1];
    }
    
    /**
     * To add two matrixes of integers of the same size.
     * @param matrix1
     * @param matrix2
     * @return 
     */
    public static int[][] arrayAddMatrixes(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        if (arrayIsMatrix(matrix1) && arrayIsMatrix(matrix2) 
                && matrix1.length == matrix2.length 
                && matrix1[0].length == matrix2[0].length) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        }
        return result;
    }

    /**
     * Ckecks if a two dimensional array is a matrix. Which means, it has all
     * its rows the same length.
     * @param array
     * @return 
     */
    public static boolean arrayIsMatrix(int[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].length != array[i + 1].length) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a string form of a two dimensional array.
     * @param matrix
     * @return 
     */
    public static String matrixToString(int[][] matrix) {
        String result = "";
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                result += row[j] + "\t";
            }
            result += "\n";
        }
        return result;
    }
    
    /**
     * To convert an ArrayList to an array.
     * @param source
     * @return 
     */
    public static int[] listToArray(List<Integer> source) {
        int[] result = new int[source.size()];
        int index = 0;
        for (Integer elem : source) {
            result[index++] = elem;
        }
        return result;
    }
    
    /**
     * To find all pairs of elements in an array of integers whose sum is equal
     * to a specified number.
     * @param array
     * @param sum
     * @return 
     */
    public static List<Integer[]> arrayFindPairsSum(int[] array, int sum) {
        List<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    result.add(new Integer[]{array[i], array[j]});
                }
            }
        }
        return result;
    }
    
    /**
     * To test the equality of two arrays.
     * @param arr1
     * @param arr2
     * @return 
     */
    public static boolean arrayIsEqual(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * To find a missing number(s) of a series in a sorted array.
     * @param array
     * @return 
     */
    public static List<Integer> seriesMissingNumbers(int[] array) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array);
        if (arraySum(array) != array.length * ((array.length + 1) / 2)) {
            int difference = seriesSpecifyDifference(array);
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] - array[i] != difference) {
                    int missingElem = array[i] + difference;
                    while (missingElem < array[i + 1]) {
                        result.add(missingElem);
                        missingElem += difference;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Specifies the difference of a series.
     * @param array
     * @return 
     */
    public static int seriesSpecifyDifference(int[] array) {
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            difference = Math.min(difference, array[i + 1] - array[i]);
        }
        return difference;
    }
    
    /**
     * To find common elements from three non-decreasing sorted arrays.
     * @param array1
     * @param array2
     * @param array3
     * @return 
     */
    public static Integer[] arrayCommonElements(
            int[] array1, 
            int[] array2, 
            int[] array3) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        Arrays.sort(array3);
        int[] array12 = arrayConvertToInt(arrayCommonElements(array1, array2));
        return arrayCommonElements(array3, array12);
    }
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int[] arrayConvertToInt(Integer[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) array[i];
        }
        return result;
    }
    
    /**
     * To move all 0's to the end of an array. Maintain the relative order of
     * the other (non-zero) array elements.
     * @param array
     * @return 
     */
    public static int[] arrayZerosToEnd(int[] array) {
        int[] result = new int[array.length];
        int index = 0;
        for (int elem : array) {
            if (elem != 0) {
                result[index++] = elem;
            }
        }
        return result;
    }
    
    /**
     * To find the number of even and odd integers in a given array of integers.
     * @param source
     * @return 
     */
    public static Map<String, List<Integer>> arrayEvenOdd(int[] source) {
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("Even", new ArrayList<>());
        result.put("Odd", new ArrayList<>());
        for (int elem : source) {
            if (elem % 2 == 0) {
                List<Integer> temp = result.get("Even");
                temp.add(elem);
                result.put("Even", temp);
            } else {
                List<Integer> temp = result.get("Odd");
                temp.add(elem);
                result.put("Odd", temp);
            }
        }
        return result;
    }
    
    /**
     * To get the difference between the largest and smallest values in an array
     * of integers. The length of the array must be 1 and above.
     * @param array
     * @return 
     */
    public static int arrayMaxMinDiff(int[] array) {
        return arrayMax(array) - arrayMin(array);
    }
    
    /**
     * To compute the average value of an array of integers except the largest
     * and smallest values.
     * @param array
     * @return 
     */
    public static double arrayAverageWithoutMaxMin(int[] array) {
        return (arraySum(array) - arrayMax(array) - arrayMin(array))
                / (double) (array.length - 2);
    }
    
    /**
     * To check if an array of integers without the given number(s).
     * @param source
     * @param without
     * @return 
     */
    public static boolean arrayWithout(int[] source, int[] without) {
        for (int sourceElem : source) {
            for (int withoutElem : without) {
                if (sourceElem == withoutElem) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * To check if an array of integers contains one or more of the specified
     * elements.
     * @param source
     * @param with
     * @return 
     */
    public static boolean arrayWith(int[] source, int[] with) {
        // not sure that works correctly
        int matches = 0;
        for (int sourceElem : source) {
            for (int i = 0; i < with.length; i++) {
                if (sourceElem == with[i]) {
                    matches++;
                    with = arrayRemoveIndex(with, i);
                    break;
                }
            }
        }
        return matches == with.length;
    }
    
    /**
     * To check if an array of integers contains only the specified elements.
     * @param source
     * @param only
     * @return 
     */
    public static boolean arrayContainsOnly(int[] source, int[] only) {
        for (int elem : source) {
            if (!arrayContains(only, elem)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * To check if an array of integers contains all of the specified
     * elements.
     * @param source
     * @param with
     * @return 
     */
    public static boolean arrayContainsAll(int[] source, int[] with) {
        for (int elem : with) {
            if (!arrayContains(source, elem)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * To remove the duplicate elements of a given array and return the new
     * length of the array.
     * @param array
     * @param num
     * @return 
     */
    public static int arrayRemoveDuplicates(int[] array, boolean num) {
        array = arrayConvertToInt(arrayRemoveDuplicates(array));
        return num ? array.length : 1;
    }
    
    /**
     * To find the length of the longest consecutive elements sequence from a
     * given unsorted array of integers.
     * @param array
     * @param difference
     * @return 
     */
    public static int seriesLongestPart(int[] array, int difference) {
        Arrays.sort(array);
        int result = 1;
        for (int i = 0; i < array.length - 1; i++) {
            int longest = 1;
            while (i < array.length - 1 &&
                     array[i + 1] - array[i] == difference) {
                longest++;
                i++;
            }
            result = Math.max(result, longest);
        }
        return result;
    }
    
    /**
     * To find the length of the longest consecutive elements sequence from a
     * given unsorted array of integers.
     * @param nums
     * @return 
     */
    public static int longest_sequence(int[] nums) {
        final HashSet<Integer> h_set = new HashSet<>();
        for (int i : nums) h_set.add(i);
        int longest_sequence_len = 0;
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; h_set.contains(j); --j) {
                h_set.remove(j);
                ++length;
            }
            for (int j = i + 1; h_set.contains(j); ++j) {
                h_set.remove(j);
                ++length;
            }
            longest_sequence_len = Math.max(longest_sequence_len, length);
        }
        return longest_sequence_len;
    }
    
    /**
     * To find the sum of the two elements of a given array which is equal to a
     * given integer.
     * @param array
     * @param target
     * @return 
     */
    public static HashMap<Integer, int[]> arraySumTarget(
            int[] array, 
            int target) {
        HashMap<Integer, int[]> result = new HashMap<>();
        int index = 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    result.put(index++, new int[]{i, j});
                }
            }
        }
        return result;
    }
    
    /**
     * To find all the unique triplets such that sum of all the three elements
     * [x, y, z (x ≤ y ≤ z)] equal to a specified number.
     * @param array
     * @param target
     * @return 
     */
    public static List<List<Integer>> arrayTripletTarget(
            int[] array, 
            int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == target) {
                        List<Integer> foundOne = Arrays.asList(
                                new Integer[]{array[i], array[j], array[k]});
                        result.add(foundOne);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * To create an array of its primitive diagonals from a given square matrix.
     * @param matrix
     * @return 
     */
    public static int[][] matrixToPrimDiagonal(int[][] matrix) {
        int[][] result = new int[(2 * matrix.length) - 1][];
        if (!arrayIsMatrix(matrix)) {return result;}
        int[] base = matrixToArray(matrix);
        int resultRow = 0;
        int index = 0;
        int rowLength = 1;
        boolean flag = true;
        for (int i = 0; i < (2 * matrix.length) - 1; i++) {
            int[] nextRow = new int[rowLength];
            for (int j = 0; j < rowLength; j++) {
                nextRow[j] = base[index++];
            }
            result[resultRow++] = nextRow;
            if (rowLength == matrix.length) {flag = false;}
            rowLength += flag ? 1 : -1;
        }
        return result;
    }

    /**
     * Creates a one dimensional array froma two dimensional one.
     * @param matrix
     * @return 
     */
    public static int[] matrixToArray(int[][] matrix) {
        int[] result = new int[matrix.length * matrix.length];
        int index = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                result[index++] = elem;
            }
        }
        return result;
    }
    
    /**
     * To create an array of its diagonals from a given square matrix.
     * @param matrix
     * @return 
     */
    public static int[][] matrixToDiagonal(int[][] matrix) {
        int[][] result = new int[(2 * matrix.length) - 1][];
        if (!arrayIsMatrix(matrix)) {return result;}
        int rowLength = 1;
        int resultRow = 0;
        boolean flag = true;
        for (int i = 0; i < (2 * matrix.length) - 1; i++, 
                rowLength += flag ? 1 : -1) {
            int[] nextRow = new int[rowLength];
            for (int index = 0, col = flag ? 0 : i - matrix.length + 1,
                    row = flag ? i : matrix.length - 1; 
                    index < rowLength && col + row <= i; col++, row--) {
                nextRow[index++] = matrix[row][col];
            }
            result[resultRow++] = nextRow;
            if (rowLength == matrix.length) {flag = false;}
        }
        return result;
    }
    
    /**
     * To create an array of its anti-diagonals from a given square matrix.
     * @param matrix
     * @return 
     */
    public static int[][] matrixToAntiDiagonal(int[][] matrix) {
        int[][] result = new int[(2 * matrix.length) - 1][];
        if (!arrayIsMatrix(matrix)) {return result;}
        int rowLength = 1;
        int resultRow = 0;
        boolean flag = true;
        for (int i = 0; i < (2 * matrix.length) - 1; i++, 
                rowLength += flag ? 1 : -1) {
            int[] nextRow = new int[rowLength];
            for (int index = 0, row = flag ? 0 : i - matrix.length + 1,
                    col = flag ? i : matrix.length - 1; 
                    index < rowLength && row + col <= i; row++, col--) {
                nextRow[index++] = matrix[row][col];
            }
            result[resultRow++] = nextRow;
            if (rowLength == matrix.length) {flag = false;}
        }
        return result;
    }
    
    /**
     * To print diagonal matrix.
     * @param matrix
     * @return 
     */
    public static String diagonalString(int[][] matrix) {
        final String TAB = "\t";
        String result = "";
        int tabs = matrix.length / 2;
        boolean flag = true;
        for (int[] row : matrix) {
            for (int i = 0; i < tabs; i++) {
                result += TAB;
            }
            for (int elem : row) {
                result += elem + TAB + TAB;
            }
            result += "\n";
            if (tabs == 0) {
                flag = false;
            }
            tabs += flag ? -1 : 1;
        }
        return result;
    }
}