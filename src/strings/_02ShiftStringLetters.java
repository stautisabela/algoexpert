/*
Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that
returns a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k
is the key.

Note that the letters should wrap around the alphabet; in other words, the letter z shifted by one return the letter a.
 */
package strings;

public class _02ShiftStringLetters {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(caesarCypherEncriptor(str, 3));
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  Most programming languages have built-in functions that will take a character and return its unicode value, and for
//  this solution we'll be taking advantage of that. The codes for the alphabet letters are from 97 (a) to 122 (z), so
//  if the .
//  - Time complexity is O(N) where N is the length of the string.
//  - Space complexity o (N) where N is the length of the string, because we're building a new char[].
    public static String caesarCypherEncriptor(String str, int key) {
        int newKey = key % 26; // simplifying the key value in case it traverses the alphabet more than once.
        char[] encryptedString = new char[str.length()];
        char newChar;

        for (int i=0; i < str.length(); i++) {
            newChar = getNewLetter(str.charAt(i), newKey);
            encryptedString[i] = newChar;
        }
        return new String(encryptedString);
    }

    public static char getNewLetter(char letter, int key) {
        int newLetterCode = letter + key;
        if (newLetterCode > 122) {
            return (char)(96 + (newLetterCode % 122));
        }
        return (char)newLetterCode;
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 2-----

//  On this solution instead of unicode we create a string with all alphabet letters, then get the index of the desired
//  letter in the string, add the key to it, and get the char in that index to add to the new encrypted chat[].
//  - Time complexity is O(N).
//  - Space complexity is O(N).
    public static String encryptingWithoutUnicode(String str, int key) {
        int newKey = key % 26;
        char[] encryptedString = new char[str.length()];
        char newChar;

        for (int i=0; i < str.length(); i++) {
            newChar = getNewLetterWithoutUnicode(str.charAt(i), newKey);
            encryptedString[i] = newChar;
        }
        return new String(encryptedString);
    }

    public static char getNewLetterWithoutUnicode(char letter, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int newLetterCode = alphabet.indexOf(letter) + key;
        if (newLetterCode > 25) {
            return alphabet.charAt(newLetterCode % 26);
        }
        return alphabet.charAt(newLetterCode);
    }
}