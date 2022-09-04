/*
Given an array of positive integers representing the values of coins in your possession, write a function that returns
the minimum amount of change (the minimum sum of money) that you cannot create. The given coins can have any positive
integer value and aren't necessarily unique.

Sample input: coins = [5, 7, 1, 1, 2, 3, 22]
Sample output: 20
 */
package arrays;

import java.util.Arrays;

public class _05NonConstructibleChange {

    public static void main(String[] args) {

    }

//  On this solution we sort the array and traverse it summing all the existing values and comparing the current sum
//  with the next coin. If the coin is grater than the current sum + 1, then the current sum + 1 cannot be made with the
//  given coins.
//  - Time is O(N.log(N)) where N is the length of the coins, because we have to sort the input array. If it was already
//  sorted we could make it in O(N) time complexity.
//  - Space complexity is O(1).
    public static int impossibleMoneyChange(int[] coins) {
        Arrays.sort(coins);
        int currentSum = 0;
        for (int coin : coins) {
            if (coin > currentSum + 1) {
                return currentSum + 1;
            }
            currentSum += coin;
        }
        return currentSum + 1;
    }
}