package strings;

import java.util.HashMap;

public class _05FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findNonRepeatingCharacter("gdfgkdfgl"));
    }

    public static int findNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i=0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
        }

        for (int i=0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (charCount.get(currentChar) == 1) {
                return i;
            }
        }
        return -1;
    }
}
/*
Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's
first non-repeating character.
 */