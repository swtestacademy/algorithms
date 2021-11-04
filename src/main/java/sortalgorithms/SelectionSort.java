package sortalgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Selection sort is an order of n square (On2) in-place algorithm. It does not require too much swapping like bubble sort.
 * Theory: I will explain the selection sort theory with ASCENDING sorting which means sorting from smallest to biggest.
 * We guess the index 0 is the biggest element in the selection sort, and the last element of the array is the indexToBeSorted.
 * We traverse the array from the first index to the indexToBeSorted. For each iteration, we  compare (the biggest index value) with
 * (the current+1 index value), and if the (the current+1 index value) is bigger than the (the biggest index value),
 * then we will assign the (the biggest index) to (the current+1 index). We will do these checks until we reach the indexToBeSorted.
 * After that, we swap (the biggest index value) with (the indexToBeSorted value).
 * We will do these checks for each element of the array by descending the indexToBeSorted index.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };

        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingSelectionSort(unsortedArray)) + "\n");
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingSelectionSort(unsortedArray)) + "\n");
    }

    public static int[] ascendingSelectionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();

        //Selection sort with ascending order
        for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
            int indexOfBiggestValue = 0;
            for (int index = 0; index < indexTobeSorted; index++) {
                if (array[index + 1] > array[indexOfBiggestValue]) {
                    indexOfBiggestValue = index + 1;
                }
            }
            swap(array, indexOfBiggestValue, indexTobeSorted);
        }

        Instant end = Instant.now();
        System.out.println("Elapsed time of ascendingSelectionSort: " + Duration.between(start, end).toNanos());
        return array;
    }

    public static int[] descendingSelectionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Instant start = Instant.now();

        //Selection sort with descending order
        for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
            int indexOfSmallestValue = 0;
            for (int index = 0; index < indexTobeSorted; index++) {
                if (array[index + 1] < array[indexOfSmallestValue]) {
                    indexOfSmallestValue = index + 1;
                }
            }
            swap(array, indexOfSmallestValue, indexTobeSorted);
        }

        Instant end = Instant.now();
        System.out.println("Elapsed time of descendingSelectionSort: " + Duration.between(start, end).toNanos());
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
