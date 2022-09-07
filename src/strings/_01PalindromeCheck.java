/*
Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a
palindrome. A palindrome is defined as a string that's written the same forward and backward. Note that single-character
strings are palindromes.
 */
package strings;

public class _01PalindromeCheck {

    public static void main(String[] args) {

    }

//  On this solution we create pointers at the beginning and end of the string and compare them until a difference is
//  found.
//  - Time complexity is O(N).
//  - Space complexity is O(1).
    public static boolean isAPalindrome(String str) {
        int begin = 0;
        int end = str.length() - 1;

        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}