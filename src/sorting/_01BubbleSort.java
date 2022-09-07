/*
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Bubble Sort
algorithm to sort the array.
 */
package sorting;

public class _01BubbleSort {
    public static void main(String[] args) {

    }

//  Bubble sort is the simplest and less performatic sorting algorithm in terms of time. It iterates the array multiple
//  times, comparing the elements in pairs and swapping their positions if they are in the wrong order. At each loop,
//  the final number will be at the right place, so we can optionally add a counter to skip the numbers that were sorted
//  already.
//  - Time complexity is O(N^2) because we traverse the array multiple times, until it gets sort, and in the worst case
//  we will traverse it N times. In the best scenario, when the array is already sorted, the complexity is just O(N).
//  - Space complexity is O(1).
    private int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        int temp;

        while(!isSorted) {
            int counter = 0;
            isSorted = true;
            for (int i=0; i<(array.length-1-counter); i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                    counter++;
                }
            }
        }
        return array;
    }
}
