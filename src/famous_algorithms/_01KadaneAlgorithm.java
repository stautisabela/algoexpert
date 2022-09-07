/*
Write a function that takes in a non-empty array of integers and returns the maximum sum that can be obtained by sum-
ming up all of tge integers in a non-empty subarray of the input array. A subarray must only contain adjacent numbers
(numbers next to each other in the input array)

SAMPLE INPUT
array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]

SAMPLE OUTPUT
19 ([1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1])
 */
package famous_algorithms;

public class _01KadaneAlgorithm {
    public static void main(String[] args) {

    }

//  On this solution we will have the currentMax value, that will be updated by every value in the array and will be re-
//  started when the previous subarray can be discarded, and the maxSum, that will only be changed if increased.
//  - Time complexity is O(N) where N is the length of the given array.
//  - Space complexity is O(1).
    public int kadanesAlgorithm(int[] array) {
        int currentMax = array[0];
        int maxSum = array[0];

        for(int i=1; i<array.length; i++) {
            currentMax = (currentMax + array[i]) > array[i] ? currentMax + array[i] : array[i];
            if (currentMax > maxSum) {
                maxSum = currentMax;
            }
        }
        return maxSum;
    }
}
