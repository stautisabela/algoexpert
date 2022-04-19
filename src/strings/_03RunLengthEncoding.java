package strings;

import java.util.Collections;

public class _03RunLengthEncoding {
    public static void main(String[] args) {

        System.out.println(runLengthEncoding("AAAAABBBBCCCDDEEEE"));
        System.out.println(reverseRunLengthEncoding("5A4B3C2D4E"));

    }

    public static String runLengthEncoding(String str) {
        int count = 1;
        StringBuilder encodedString = new StringBuilder();
        /* Avoid string concatenation because Strings are immutable, so instead of editing an existing object, a new
        object is created at every concatenation. Use StringBuilder or char[] instead */

        for (int i=1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i-1) || count == 9) {
                encodedString.append(count);
                encodedString.append(str.charAt(i - 1));
                count = 0;
            }
            count++;
        }

        // handling the last run
        encodedString.append(count);
        encodedString.append(str.charAt(str.length() - 1));
        return encodedString.toString();
    }

    public static String reverseRunLengthEncoding(String str) {
        int pointer = 0;
        StringBuilder encodedString = new StringBuilder();

        while (pointer < str.length()) {
            if (pointer % 2 != 0) {
                int reps = Character.getNumericValue(str.charAt(pointer - 1));
                String repeatedChar = String.valueOf(str.charAt(pointer));
                encodedString.append(String.join("", Collections.nCopies(reps, repeatedChar)));
            }
            pointer ++;
        }
        return encodedString.toString();
    }

}
/*
Write a function that takes in a non-empty string and returns its run-length encoding (ex. AAA -> 3A)
 */