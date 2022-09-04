/*
The Fibonacci sequence is defined as follows: the first number of the sequence is 0, the second number is 1, and the nth
number is the sum of the (n-1)th and (n-2)th numbers. Write a function that takes in an integer n and returns the nth
Fibonacci number.
 */
package recursion;

import java.util.HashMap;
import java.util.Map;

public class _01NthFibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacci(5));
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  - Time complexity is O(2^n), each call for the function makes 2 other calls. The main function will call 2 other
//  functions, each one will call another 2 functions, that will call another 2 functions and so on.
//  - Space complexity is O(n), even though there are no new information being stored, there's a function calls stack
//  for the recursive functions, that only stops running after all others stop as well. There are at most N functions
//  running at the same time.
    private static int getFibonacci(int n) {
        if (n==1) return 0;
        else if (n==2) return 1;
        else {
            return(getFibonacci(n-1) + getFibonacci(n-2));
        }
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 2-----

//  We store Finobacci numbers in a memoize hashtable so we can access them when needed, instead of calculating the
//  same value multiple times, like the previous solution
//
//  - Time complexity is O(n), we have to calculate each Fibonacci number (a total of N) once, after that we can access
//  them in constant time.
//  - Space complexity is O(n), we still have the call stack issue because it uses a recursive function.
    private static int memoizeFibonacci(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1,0);
        memoize.put(2, 1);

        if (!memoize.containsKey(n)) {
            memoize.put(n, memoizeFibonacci(n-1) + memoizeFibonacci(n-2));
        }
        return memoize.get(n);
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 3-----

//  - Time complexity is O(n), we have to calculate each Fibonacci number (a total of N) once.
//  - Space complexity is O(1).
    private static int nonRecursiveFibonacci(int n) {
        int[] lastTwo = {0, 1};
        int nextFib;
        int counter = 3;

        while (counter <= n) {
            nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n == 1 ? lastTwo[0] : lastTwo[1];
    }
}