package sortalgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Bubble sort algorithm is an order of n square (On2) algorithm.
 * Theory: We should traverse the array from left to right and sort the last element position, called indexToBeSorted.
 * We can do this by sorting both ascending and descending. Let's continue with ascending sorting. We will go one by one in an array
 * and each time, we should check the current index value with index+1 value, and if the next index value is bigger than the previous one,
 * we should swap the values by calling the swap function. We should do this until we hit the indexToBeSorted. At this point, we have already
 * sorted the index which we want to sort. After this loop round, we should decrease the indexTobeSort minus one and do the same operation
 * while indexToBeSorted value is bigger than zero.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };

        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingBubbleSort(unsortedArray)) + "\n");
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingBubbleSort(unsortedArray)) + "\n");

    }

    public static int[] ascendingBubbleSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
            for (int index = 0; index < indexTobeSorted; index++) {
                if (array[index] > array[index + 1]) {
                    swap(array, index, index + 1);
                }
            }
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingBubbleSort: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] descendingBubbleSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();
        for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
            for (int index = 0; index < indexTobeSorted; index++) {
                if (array[index] < array[index + 1]) {
                    swap(array, index, index + 1);
                }
            }
        }
        Instant end = Instant.now();
        System.out.println("Elapsed time of descendingBubbleSort: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            int temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
        }
    }
}
