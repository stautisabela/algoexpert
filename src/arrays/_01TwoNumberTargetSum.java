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

    // this solution is preferred to nesting 2 for loops because it has less time complexity, although it uses more space
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

    // this has less space complexity (constant space) than the hash table solution, but a little bit more time complexity
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
/*
Write a fgunction that takes in a non-empty array pf distinct integers and an integer representing a target sum. If any
two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If
no two numbers sum up to the target sum, the function should return an empty array.
 */
