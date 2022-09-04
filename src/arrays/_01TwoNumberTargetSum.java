/*
Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any
two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If
no two numbers sum up to the target sum, the function should return an empty array.
 */
package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _01TwoNumberTargetSum {
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        hashTableSolution(array, targetSum);
        pointerSolution(array, targetSum);
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  On this solution we create an empty set to make use of its contain() method. We traverse the array and see if the
//  set has the other number needed to hit the target sum. In other languages it would use a HashMap with the number as
//  key and True as value.
//  - Time complexity is O(N) where N is the length of the given array, because we traverse the array.
//  - Space complexity is O(N) where N is the length of the given array, because we add the values to a Set.
    public static int[] hashTableSolution(int[] array, int targetSum) {
        Set<Integer> numbers = new HashSet<>();

        for(int number : array) {
            if (numbers.contains(targetSum - number)) {
                return new int[] {number, targetSum - number};
            } else {
                numbers.add(number);
            }
        }
        return new int[0];
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 2-----

//  On this solution we sort the array and create pointers in the beginning and end of the array. We sum both pointers
//  and move them depending on the sum being more or less than the target sum.
//  - Time complexity if O(N.log(N)), the same as a quicksort algorithm.
//  - Space complexity is O(1).
    public static int[] pointerSolution(int[] array, int targetSum) {
        int left = 0;
        int right = array.length - 1;

        Arrays.sort(array);
        while (left < right) {
            int currentSum = array[left] + array[right];

            if (currentSum == targetSum) return new int[] {array[left], array[right]};
            else if (currentSum > targetSum) right--;
            else if (currentSum < targetSum) left++;
        }
        return new int[0];
    }
}
