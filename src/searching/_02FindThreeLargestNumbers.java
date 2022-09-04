/*
Write a function that takes in an array of at least three integers and, without sorting the input array, returns a sorted
array of the three largest integers in the input array.

The function should return duplicate integers if necessary: for example, it should return [10, 10, 12] for the input
array of [10, 5, 9, 10, 12]
 */
package searching;

public class _02FindThreeLargestNumbers {
    public static void main(String[] args) {
        int[] array = new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(findThreeLargestNumbers(array));
    }



//  - Time complexity is O(N) where N is the length of the input array, because we traverse the entire array, consider-
//  ing it's not sorted.
//  - Space complexity is O(1).
    private static int[] findThreeLargestNumbers(int[] array) {

        int[] largestNums = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int n : array) {
            if (n > largestNums[2]) {
                sortArray(2, n, largestNums);
            }
            else if (n > largestNums[1]) {
                sortArray(1, n, largestNums);
            }
            else if (n > largestNums[0]) {
                sortArray(0, n, largestNums);
            }
        }
        return largestNums;
    }

    private static void sortArray (int index, int number, int[] array) {
        for (int i=0; i<index; i++) {
            array[i] = array[i+1];
        }
        array[index] = number;
    }
}
