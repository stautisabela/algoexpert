package arrays;

import java.util.Arrays;

public class _03SortedSquaresArray {
    public static void main(String[] args) {

    }

    public static int[] sortedSquares(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i] * array[i];
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    // alternative, linear-time solution that only works because the array is sorted
    public static int[] linearSortedSquares(int[] array) {
        int[] sortedArray = new int[array.length];
        int start = 0;
        int end = array.length - 1;
        int smallerValue, largerValue;

        for (int i = array.length - 1; i >= 0; i++) {
            smallerValue = array[start];
            largerValue = array[end];

            if (Math.abs(smallerValue) > largerValue) {
                sortedArray[i] = smallerValue * smallerValue;
                start++;
            }
            else {
                sortedArray[i] = largerValue * largerValue;
                end--;
            }
        }
        return sortedArray;
    }
}
/*
Wirte a function that takes in a non-empty array of integers that are sorted in ascending order and returns a new array
of the same length with the squares of the original integers also sorted in ascending order
 */