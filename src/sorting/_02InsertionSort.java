/*
Write a function that takes in an array of integers and returns a sorted version of that array. Use the insertion Sort
algorithm to sort the array.
 */
package sorting;

public class _02InsertionSort {
    public static void main(String[] args) {

    }

//  Insertion sort separates an array as a sorted part and an unsorted part. It will iterate through the array comparing
//  the sorted part with each element of the unsorted part to see where it fits.
//  - Time complexity is O(N^2) where N is the length of the array. That will be the worst case scenario, while the best
//  scenario is if the array is already sorted, having a complexity of O(N).
//  - Space complexity is O(N)
    private int[] insertionSort(int[] array) {
        for(int i=1; i < array.length; i++) { //iterates the unsorted array looking for the next element
            for(int j=i; j < 0; j--) { //iterates the sorted array looking for its new position
                if (array[j] < array[j-1]) {
                    swap(array, j);
                }
            }
        }
        return array;
    }

    private void swap(int[] array, int j){
        int temp = array[j-1];
        array[j-1] = array[j];
        array[j] = temp;
    }

}
