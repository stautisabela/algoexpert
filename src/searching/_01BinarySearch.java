/*
Write a function that takes in a sorted array of integers as well as a target integer. The function should use the bi-
nary search algorithm to determine if the target integer is contained in the array and should return its index if it is,
otherwise return -1.

SAMPLE INPUT
array = [0, 1, 21, 33, 45, 45, 61, 71, 72, 73]
target = 33

SAMPLE OUTPUT
3
 */
package searching;

public class _01BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}, 6));
    }



//  - Time complexity is O(log(N)) where N is the length of the input array. We eliminate half of the input everytime we
//  traverse the loop.
//  - Space complexity is O(i).
    private static int binarySearch(int[] array, int target) {
        int middle;
        int left = 0;
        int right = array.length-1;

        while (left <= right) {
            middle = (right + left)/2;

            if (target < array[middle]) {
                right = middle-1;
            }
            else if (target > array[middle]) {
                left = middle + 1;
            }
            else { // when target == array[middle]
                return middle;
            }
        }
        return -1;
    }
}
