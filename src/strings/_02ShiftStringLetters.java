package strings;

public class _02ShiftStringLetters {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(caesarCypherEncriptor(str, 3));
    }

    public static String caesarCypherEncriptor(String str, int key) {
        int newKey = key % 26;
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

/*
Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that
returns a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k
is the key.
 */