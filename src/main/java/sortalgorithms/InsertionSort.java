package sortalgorithms;

import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Insertion sort is an order of n square (On2) in-place algorithm.
 * Theory: I will explain the insertion sort theory with ASCENDING sorting which means sorting from smallest to biggest.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };
        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingInsertionSort(unsortedArray)));
        System.out.println("Ascending Sorted Array Simpler: " + Arrays.toString(ascendingInsertionSortSimple(unsortedArray)));
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingInsertionSort(unsortedArray)));
    }

    public static int[] ascendingInsertionSortSimple(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int elementStartingToSort = array[indexStartingToSort];
            int i;
            for (i = indexStartingToSort; i > 0 && elementStartingToSort < array[i - 1]; i--) {
                array[i] = array[i - 1];
            }
            array[i] = elementStartingToSort;
        }
        return array;
    }

    public static int[] descendingInsertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int elementStartingToSort = array[indexStartingToSort];
            int i;
            for (i = indexStartingToSort; i > 0 && elementStartingToSort > array[i - 1]; i--) {
                array[i] = array[i - 1];
            }
            array[i] = elementStartingToSort;
        }
        return array;
    }

    public static int[] ascendingInsertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        for (int indexStartingToSort = 1; indexStartingToSort < array.length; indexStartingToSort++) {
            int elementStartingToSort = array[indexStartingToSort];
            int i;
            for (i = indexStartingToSort; i > 0; i--) {
                if (elementStartingToSort < array[i - 1]) {
                    array[i] = array[i - 1];
                    if (i == 1) {
                        array[0] = elementStartingToSort;
                    }
                } else {
                    array[i] = elementStartingToSort;
                    break;
                }
            }
        }
        return array;
    }
}
