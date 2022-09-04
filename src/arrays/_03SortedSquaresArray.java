/*
Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns a new array
of the same length with the squares of the original integers also sorted in ascending order
 */
package arrays;

import java.util.Arrays;

public class _03SortedSquaresArray {
    public static void main(String[] args) {

    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  - Time complexity is O(N.log(N)) because that's the best time complexity when sorting an array using a sorting algo-
//  rithm like quicksort or mergesort.
//  - Space complexity is O(N).
    public static int[] sortedSquares(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i] * array[i];
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }




//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  On this solution we add pointers to the beginning and end of the given array and compare the module of the pointers
//  before adding them to the new, sorted array. This solution only works because the input array is sorted.
//  - Time complexity is O(N).
//  - Space complexity is O(N).
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