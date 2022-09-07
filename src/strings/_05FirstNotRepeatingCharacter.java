/*
Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's
first non-repeating character.
The first non-repeating character is the first character in a string that occurs only once.

If the input string doesn't have any non-repeating characters, your function should return -1.
 */
package strings;

import java.util.HashMap;

public class _05FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findNonRepeatingCharacter("gdfgkdfgl"));
    }



//  On this solution we create a HashMap to store every character in the string and how many times it appears. Then we
//  traverse the HashMap looking for a key with value 1.
//  - Time complexity is O(N) where N is the string length, because we traverse N twice and the O notation doesn't care
//  about constants.
//  - Space complexity is O(1), even though we are adding elements to the HashMap, it is at most 26 characters, so it is
//  constant space.
    public static int findNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        char currentChar;

        for (int i=0; i < string.length(); i++) {
            currentChar = string.charAt(i);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
        }

        for (int i=0; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if (charCount.get(currentChar) == 1) {
                return i;
            }
        }
        return -1;
    }
}