/*
Write a function that takes in a non-empty string and returns its run-length encoding (ex. AAA -> 3A).

To make things more complicated, however, the input string can contain all sorts of special characters, including num-
bers. And since encoded data must be decodable, this means that we can't naively run-length-encode long runs. For
example, the run "AAAAAAAAAAAA"(12 As) can't naively be encoded as "12A", since this string can be decoded as 1AA. Thus,
long runs (of 10 or more characters) should be encoded in a split fashion; the aforementioned run should be encoded as
9A3A.
 */
package strings;

import java.util.Collections;

public class _03RunLengthEncoding {
    public static void main(String[] args) {

        System.out.println(runLengthEncoding("AAAAABBBBCCCDDEEEE"));
        System.out.println(reverseRunLengthEncoding("5A4B3C2D4E"));

    }



//  On this solution we will create a StringBuilder to receive the encoded string. We're using a string builder because
//  because we'll append it, and because Strings are immutable, everytime we use string concatenation we are  actually
//  creating a new object at every concatenation, instead of editing an existing object; char[] could have been used
//  too. Then we will traverse the input array starting from the 2nd element and comparing it to the previous element to
//  see if they are the same, counting the repetitions until the 9th time before adding it to the encodedString.
//  - Time complexity is O(N) where N is the length of the input String, because we're traversing it.
//  - Space complexity is O(N) where N is the length of the input String, because we're appending the new StringBuilder
//  everytime we traverse the input.
    public static String runLengthEncoding(String str) {
        int count = 1;
        StringBuilder encodedString = new StringBuilder();

        for (int i=1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i-1) || count == 9) {
                encodedString.append(count);
                encodedString.append(str.charAt(i - 1));
                count = 0;
            }
            count++;
        }

        // handling the last run when it's unique, or the only run in a one-character string
        encodedString.append(count);
        encodedString.append(str.charAt(str.length() - 1));
        return encodedString.toString();
    }



//  Extra method to decode.
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