package sortalgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * The Shell sort algorithm is an order of n square (On2) algorithm. It is a variation of insertion sort.
 * First we need to calculate the gap (stepping/interval). Here we use array.length()/2 as a gap value.
 * Our first loop is updating gap value for each iteration with array.length()/2 formula. You can use another formula as well.
 * Inner loops are as same as insertion sort algorithm. For insertion sort, the gap value is always "1". Here, rather than "1" we update
 * the code with "gap value". So indexStartingToSort starts from gap value to end of the array and for each calculation rather than
 * using "1" we are using here "gap value".
 * For each iteration in first loop the gap value decreases by factor of gap/2 until the gap is bigger or equal to 1.
 * The final value of the gap  must be "1" and when it is "1" it does Insertion Sort.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };
        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingShellSort(unsortedArray)) + "\n");
        System.out.println("Ascending Sorted Array (With While): " + Arrays.toString(ascendingShellSortWithWhile(unsortedArray)) + "\n");
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingShellSort(unsortedArray)) + "\n");
    }

    public static int[] ascendingShellSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int gap = array.length / 2; gap >=1 ; gap /= 2) {
            for (int indexStartingToSort = gap; indexStartingToSort < array.length; indexStartingToSort++) {
                int valueStartingToSort = array[indexStartingToSort];
                int i;
                for (i = indexStartingToSort; i >= gap && valueStartingToSort < array[i - gap]; i = i - gap) {
                    array[i] = array[i - gap];
                }
                array[i] = valueStartingToSort;
            }
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingSelectionSort: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] ascendingShellSortWithWhile(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int gap = array.length / 2; gap >=1; gap /= 2) {
            for (int indexStartingToSort = gap; indexStartingToSort < array.length; indexStartingToSort++) {
                int valueStartingToSort = array[indexStartingToSort];
                int i = indexStartingToSort;
                while (i >= gap && valueStartingToSort < array[i - gap]) {
                    array[i] = array[i - gap];
                    i = i - gap;
                }
                array[i] = valueStartingToSort;
            }
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingShellSortWithWhile: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] descendingShellSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int gap = array.length / 2; gap >=1 ; gap /= 2) {
            for (int indexStartingToSort = gap; indexStartingToSort < array.length; indexStartingToSort++) {
                int valueStartingToSort = array[indexStartingToSort];
                int i;
                for (i = indexStartingToSort; i >= gap && valueStartingToSort > array[i - gap]; i = i - gap) {
                    array[i] = array[i - gap];
                }
                array[i] = valueStartingToSort;
            }
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingSelectionSort: " + Duration.between(start, end).toNanos());
        return array;
    }
}
