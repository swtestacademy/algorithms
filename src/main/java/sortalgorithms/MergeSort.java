package sortalgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Author: Onur Baskirt
 * Merge sort with recursion
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 18, 32, -11, 6, 68, 2, -34 };
        Instant start = Instant.now();

        mergeSort(array);

        Instant end = Instant.now();
        System.out.println("Elapsed time: " + Duration.between(start, end).toNanos());


        System.out.println("Ascending Sorted Array: " + Arrays.toString(array) + "\n");
    }

    private static void mergeSort(int[] array) {

        int length = array.length;

        //Exit condition of recursion
        if (length <= 1) return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array indices
        int j = 0; //right array indices

        //Populate the arrays from original array
        for (; i < length; i++) {
            if (i < middle)
                leftArray[i] = array[i];
            else {
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);

        //  int[] array = { 18, 32, -11, 6, 68, 2, -34 };
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices of array, leftArray, and rightArray

        //Merge conditions when there are elements in both left and right arrays.
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        //When there is only one element left which we cannot compare with the other one.
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        //When there is only one element left which we cannot compare with the other one.
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
}
