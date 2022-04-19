package arrays;

import java.util.List;

public class _02ValidateSubsequence {
    public static void main(String[] args) {

    }

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
/*
Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of
the first one.
 */