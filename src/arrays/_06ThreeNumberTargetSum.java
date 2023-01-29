/*
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The
function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of these
triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be
ordered in ascending order with respect to the numbers they hold.

If no three numbers sum up to the target sum, the function should return an empty array.

SAMPLE INPUT
array = [12, 3, 1, 2, -6, 5, -8, 6]
targetSum = 0

SAMPLE OUTPUT
[[-8, 2, 6],[-8, 3, 5],[-6, 1, 5]]
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _06ThreeNumberTargetSum {
    public static void main(String[] args) {

        System.out.println(threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0));
    }



//  On this solution we sort the array and traverse it once for the first number of the triplet. For the other 2, we
//  create two pointers: one right after the index of the loop for the second and one in the end of the array for the
//  third numbers in the triplet. We move the pointers depending on the comparison of the current sum with the target
//  sum.
//  - Time complexity is O(N^2), because we iterate loops. The while loop only traverse the rest of the array, not the
//  entirety of it, for it, but it still counts as N.
//  - Space complexity is O(N), where N is the length of the input array.
    private static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<>();
        Arrays.sort(array);
        for(int i=0; i < array.length-2; i++) {
            int left = i+1;
            int right = array.length-1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[left], array[right]});
                    right--;
                    left++;
                }
                else if(currentSum > targetSum) {
                    right --;
                }
                else if(currentSum < targetSum) {
                    left ++;
                }
            }
        }
        return triplets;
    }
}
