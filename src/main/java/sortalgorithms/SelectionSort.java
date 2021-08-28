package sortalgorithms;

import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Selection sort is an order of n square (On2) in-place algorithm. It does not require too much swapping like bubble sort.
 * Theory: I will explain the selection sort theory with ASCENDING sorting which means sorting from smallest to biggest.
 * We guess the index 0 is the largest element in the selection sort, and the last element of the array is the indexToBeSorted.
 * We traverse the array from the first index to the indexToBeSorted. For each iteration, we  compare (the largest index value) with
 * (the current+1 index value), and if the (the current+1 index value) is bigger than the (the largest index value),
 * then we will assign the (the largest index) to (the current+1 index). We will do these checks until we reach the indexToBeSorted.
 * After that, we swap (the largest index value) with (the indexToBeSorted value).
 * We will do these checks for each element of the array by descending the indexToBeSorted index.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };

        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingSelectionSort(unsortedArray)));
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingSelectionSort(unsortedArray)));
    }

    public static int[] ascendingSelectionSort(int[] array) {
        for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
            int largest = 0;
            for (int index = 0; index < indexTobeSorted; index++) {
                if (array[index + 1] > array[largest]) {
                    largest = index + 1;
                }
            }
            swap(array, largest, indexTobeSorted);
        }
        return array;
    }

    public static int[] descendingSelectionSort(int[] array) {
        for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
            int smallest = 0;
            for (int index = 0; index < indexTobeSorted; index++) {
                if (array[index + 1] < array[smallest]) {
                    smallest = index + 1;
                }
            }
            swap(array, smallest, indexTobeSorted);
        }
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
