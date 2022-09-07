/*
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Selection sort
algorithm to sort the array.
 */
package sorting;

public class _03SelectionSort {
    public static void main(String[] args) {
        System.out.println(selectionSort(new int[]{3, 1, 2}));
    }

//  Selection sort separates an array as a sorted part and an unsorted part. It iterates the unsorted part looking for
//  the smallest number in it and appends it to the sorted part.
//  - Time complexity is O(N^2).
//  - Space complexity is O(1).
    private static int[] selectionSort(int[] array) {
        for(int i=0; i < array.length-1; i++) {
            int smallestIdx = i;
            for (int j=i+1; j < array.length; j++) {
                if (array[j] < array[smallestIdx]) {
                    smallestIdx = j;
                }
            }
            swap(array, i, smallestIdx);
        }
        return null;
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}