package sortalgorithms;

import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Insertion sort is an order of n square (On2) in-place algorithm.
 * Theory: I will explain the insertion sort theory with ASCENDING sorting which means sorting from smallest to biggest.
 * We start sorting from index 1. It is a starting index and value at this index is called as valueStartingToSort.
 * We increase the value from index 1 to end of the array one by one and for each iteration, we have inner iteration from
 * indexStartingToSort to 0, and also we need to check that valueStartingToSort < index[i-1] if it is like that
 * array[i] should be assigned to array[i-1] and after inner loop we should assign the array[i] to valueStartingToSort.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };
        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingInsertionSort(unsortedArray)));
        System.out.println("Ascending Sorted Array (while): " + Arrays.toString(ascendingInsertionSortWhile(unsortedArray)));
        System.out.println("Ascending Sorted Array (longer): " + Arrays.toString(ascendingInsertionSortLonger(unsortedArray)));
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingInsertionSort(unsortedArray)));
    }

    public static int[] ascendingInsertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int valueStartingToSort = array[indexStartingToSort];
            int i;
            for (i = indexStartingToSort; i > 0 && valueStartingToSort < array[i - 1]; i--) {
                array[i] = array[i - 1];
            }
            array[i] = valueStartingToSort;
        }
        return array;
    }

    public static int[] ascendingInsertionSortWhile(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int valueStartingToSort = array[indexStartingToSort];
            int i = indexStartingToSort;
            while (i > 0 && valueStartingToSort < array[i - 1]) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = valueStartingToSort;
        }
        return array;
    }

    public static int[] ascendingInsertionSortLonger(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int valueStartingToSort = array[indexStartingToSort];
            int i;
            for (i = indexStartingToSort; i > 0; i--) {
                if (valueStartingToSort < array[i - 1]) {
                    array[i] = array[i - 1];
                    if (i == 1) {
                        array[0] = valueStartingToSort;
                    }
                } else {
                    array[i] = valueStartingToSort;
                    break;
                }
            }
        }
        return array;
    }

    public static int[] descendingInsertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int valueStartingToSort = array[indexStartingToSort];
            int i;
            for (i = indexStartingToSort; i > 0 && valueStartingToSort > array[i - 1]; i--) {
                array[i] = array[i - 1];
            }
            array[i] = valueStartingToSort;
        }
        return array;
    }
}
