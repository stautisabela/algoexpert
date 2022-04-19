package arrays;

import java.util.Arrays;

public class _05NonConstructibleChange {

    public static void main(String[] args) {


    }

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
/*
Given an array of positive integers representing the values of coins in your possession, write a function that returns
the minimum amount of change (the minimum sum of money) that you cannot create.
 */