package recursion;

public class _01NthFibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacci(5));
    }

    // time complexity of 2^n
    private static int getFibonacci(int n) {
        if (n==1) return 0;
        else if (n==2) return 1;
        else {
            return(getFibonacci(n-1) + getFibonacci(n-2));
        }
    }
}
/*
The Fibonacci sequence is defined as follows: the first number of the sequence is 0, the second number is 1, and the nth
number is the sum of the (n-1)th and (n-2)th numbers. Write a function that takes in an integer n and returns the nth
Fibonacci number.
 */