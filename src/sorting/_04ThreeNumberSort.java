/*
You're given an array of integers and another array of three distinct integers. The first array is guaranteed to only
contain integers that are in the second array, and the second array represents a desired order for the integers in the
first array. For example, a second array of [x, y, z] represents a desired order of [x, x, ..., x, y, y, ..., y, x, x,
..., x] in the first array.

Write a function that sorts the first array according to the desired order in the second array.

The function should perform this in place (i.e., it should mutate the input array), and it shouldn't use any auxiliary
space (i.e., it should run with constant space: O(1) space).

Note that the desired order won't necessarily be ascending or descending and that the first array won't necessarily
contain all three integers found in the second array -- it might only contain one or two.

SAMPLE INPUT
array = [1, 0, 0, -1, -1, 0, 1, 1]
order = [0, 1, -1]

SAMPLE OUTPUT
array = [0, 0, 0, 1, 1, 1, -1, -1]
 */
package sorting;


import java.util.Arrays;

public class _04ThreeNumberSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[]{0, 1, -1};
        threeNumberSum(array, order);

    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

    private static int[] threeNumberSum(int[] array, int[] order) {
        if(order.length>1) {
            int pointer = 0;

            for(int i=0; i < array.length; i++) {
                if (array[i] == order[0]) {
                    swap(pointer, i, array);
                    pointer++;
                }
            }
            pointer = array.length-1;

            for(int i=array.length-1; i >= 0; i--) {
                if(array[i] == order[order.length-1]) {
                    swap(pointer, i, array);
                    pointer--;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }



//---------------------------------------------------------------------------------------------ALTERNATIVE SOLUTION-----

//  This solution has more time complexity but it works for order arrays of any length. It traverses the array multiple
//  times looking for each number from the order and adding it to its sorted position.
//  - Time complexity is O(N*M) where N is the length of the array and M is the length of the order.
//  - Space complexity is O(1).
    private static int[] anyNumberSum(int[] array, int[] order) {
        int sortedIndex = 0;
        int temp;
        for(int orderNum : order) {
            for (int i=0; i<array.length; i++) {
                if (array[i] == orderNum) {
                    swap(sortedIndex, i, array);
                    sortedIndex++;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
