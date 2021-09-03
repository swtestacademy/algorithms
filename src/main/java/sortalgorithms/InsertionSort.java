package sortalgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Insertion sort is an order of n square (On2) in-place algorithm.
 * Theory: I will explain the insertion sort theory with ASCENDING sorting which means sorting from smallest to biggest.
 * We start sorting from index 1. It is a starting index and value at this index is called as startingValueToSort.
 * We increase the value from index 1 to end of the array one by one and for each iteration, we have inner iteration from
 * startingIndexToSort to 0, and also we need to check that startingValueToSort < index[i-1] if it is like that
 * array[i] should be assigned to array[i-1] and after inner loop we should assign the array[i] to startingValueToSort.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };
        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingInsertionSort(unsortedArray)) + "\n");
        System.out.println("Ascending Sorted Array (while): " + Arrays.toString(ascendingInsertionSortWithWhile(unsortedArray)) + "\n");
        System.out.println("Ascending Sorted Array (longer): " + Arrays.toString(ascendingInsertionSortLonger(unsortedArray)) + "\n");
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingInsertionSort(unsortedArray)) + "\n");
    }

    public static int[] ascendingInsertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int startingIndexToSort = 1; startingIndexToSort < array.length; startingIndexToSort++) {
            int startingValueToSort = array[startingIndexToSort];
            int i;
            for (i = startingIndexToSort; i >= 1 && startingValueToSort < array[i - 1]; i--) {
                array[i] = array[i - 1];
            }
            array[i] = startingValueToSort;
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingInsertionSort: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] ascendingInsertionSortWithWhile(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int startingIndexToSort = 1; startingIndexToSort < array.length; startingIndexToSort++) {
            int startingValueToSort = array[startingIndexToSort];
            int i = startingIndexToSort;
            while (i >= 1 && startingValueToSort < array[i - 1]) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = startingValueToSort;
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingInsertionSortWhile: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] ascendingInsertionSortLonger(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int startingIndexToSort = 1; startingIndexToSort < array.length; startingIndexToSort++) {
            int startingValueToSort = array[startingIndexToSort];
            int i;
            for (i = startingIndexToSort; i >= 1; i--) {
                if (startingValueToSort < array[i - 1]) {
                    array[i] = array[i - 1];
                    if (i == 1) {
                        array[0] = startingValueToSort;
                    }
                } else {
                    array[i] = startingValueToSort;
                    break;
                }
            }
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingInsertionSortLonger: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] descendingInsertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int startingIndexToSort = 1; startingIndexToSort < array.length; startingIndexToSort++) {
            int startingValueToSort = array[startingIndexToSort];
            int i;
            for (i = startingIndexToSort; i >= 1 && startingValueToSort > array[i - 1]; i--) {
                array[i] = array[i - 1];
            }
            array[i] = startingValueToSort;
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of descendingInsertionSort: " + Duration.between(start, end).toNanos());
        return array;
    }
}
