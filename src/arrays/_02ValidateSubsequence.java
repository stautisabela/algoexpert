/*
Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of
the first one.

A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same
order as they appear in the array. For instance the number [1, 3, 4] form a subsequence of the array [1, 2, 3, 4].
 */
package arrays;

import java.util.List;

public class _02ValidateSubsequence {
    public static void main(String[] args) {

    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  Time complexity is O(N) where N is the length of the main array.
//  Space complexity is O(1) because we're not storing new variables
    public static boolean solutionWhile(List<Integer> array, List<Integer> sequence) {
        int indexArray = 0, indexSequence = 0;

        while (indexArray < array.size() && indexSequence < sequence.size()) {
            if (array.get(indexArray) == sequence.get(indexSequence)) {
                indexSequence++;
            }
            indexArray++;
        }
        return indexSequence == sequence.size();
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 2-----

//  Time complexity is O(N) where N is the length of the main array.
//  Space complexity is O(1) because we're not storing new variables
    public static boolean solutionFor(List<Integer> array, List<Integer> sequence) {
        int indexSequence = 0;

        for (int number : array) {
            if (indexSequence == sequence.size()) break;

            if (number == sequence.get(indexSequence)) {
                indexSequence++;
            }
        }
        return indexSequence == sequence.size();
    }
}