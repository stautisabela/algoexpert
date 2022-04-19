package greedy_algorithms;

import java.util.Arrays;

public class _01MinimumWaitingTime {
    public static void main(String[] args) {

        int[] gfgf = new int[]{3, 2, 1, 2, 6};
        System.out.println(findMinimumWaitingTime(gfgf));
    }

    private static int findMinimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        int queriesLeft = queries.length;

        for (int i=0; i < queries.length; i++) {
            queriesLeft--;
            totalWaitingTime += queries[i] * queriesLeft;
        }
        return totalWaitingTime;

    }
}
/*
You're given a non-empty array of positive integers representing the amounts of time that specific queries take to
execute. Only one query can be executed at a time, but the queries can be executed in any order. A query's waiting time
is defined as the amount of time that it must wait before its execution starts. In other words, if a query is executed
second, then its waiting time is the duration of the first query; if a query is executed third, then its waiting time
is the sum of the first two queries.
Write a function that returns the minimum amount of total waiting time for all of the queries.
 */