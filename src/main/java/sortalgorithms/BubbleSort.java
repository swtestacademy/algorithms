package sortalgorithms;

import java.util.Arrays;

/**
 * Bubble sort algorithm is an order of n square (On2) algorithm.
 * Theory: We should traverse the array from left to right and sort the last element position, called indexToBeSort.
 * We can do this by sorting both ascending and descending. Let's continue with ascending sorting. We will go one by one in an array
 * and each time, we should check the current index value with index+1 value, and if the next index value is bigger than the previous one,
 * we should swap the values by calling the swap function. We should do this until we hit the indexToBeSort. At this point, we have already
 * sorted the index which we want to sort. After this loop round, we should decrease the indexTobeSort minus one and do the same operation
 * while indexToBeSort value is bigger than zero.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] unsortedArray = { 18, 32, -11, 6, 68, 2, -34 };

        System.out.println("Ascending Sorted Array: " + Arrays.toString(ascendingBubbleSort(unsortedArray)));
        System.out.println("Descending Sorted Array: " + Arrays.toString(descendingBubbleSort(unsortedArray)));

    }

    public static int[] ascendingBubbleSort(int[] array) {
        for (int indexTobeSort = array.length - 1; indexTobeSort > 0; indexTobeSort--) {
            for (int index = 0; index < indexTobeSort; index++) {
                if (array[index] > array[index + 1]) {
                    swap(array, index, index + 1);
                }
            }
        }
        return array;
    }

    public static int[] descendingBubbleSort(int[] array) {
        for (int indexTobeSort = array.length - 1; indexTobeSort > 0; indexTobeSort--) {
            for (int index = 0; index < indexTobeSort; index++) {
                if (array[index] < array[index + 1]) {
                    swap(array, index, index + 1);
                }
            }
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
