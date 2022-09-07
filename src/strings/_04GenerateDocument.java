/*
You're given a string of available characters and a string representing a document that you need to generate. Write a
function that determines if you can generate the document using the available characters. If you can generate the
document, your function should return true; otherwise, it should return false.

You're only able to generate the document if the frequency of unique characters in the characters string is grater than
or equal to the frequency of unique characters in the document string. So if you're given characters = "abcabc" and
document = "aabbccc" you cannot generate the document because you're missing one c.

The document you need to create may contain any characters, including special characters, capital letters, numbers, and
spaces.

SAMPLE INPUT:
characters: "Bste!hetsi ogEAxpelrt x ",
document: "AlgoExpert is the Best!"

SAMPLE OUTPUT:
true
 */
package strings;

import java.util.Arrays;
import java.util.HashMap;

public class _04GenerateDocument {
    public static void main(String[] args) {
        System.out.println(canGenerateDocument("z xncc*vb  bKnkm", "c*vk bxKn"));
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  On this solution we will sort both given Strings, and then we iterate the given characters comparing them with each
//  character from the document. If we manage to go through the entire document, we return true.
//  - Time complexity is (N.log(N)) because we're using a sorting algorithm.
//  - Space complexity is O(1).
    public static boolean canGenerateDocument(String characters, String document) {

        if (document.length() > characters.length()) return false;
        if (document.isBlank() || document.isEmpty()) return true;

        // sorting strings
        char sortedCharacters[] = characters.toCharArray();
        char sortedDocument[] = document.toCharArray();
        Arrays.sort(sortedCharacters);
        Arrays.sort(sortedDocument);

        int docIndex = 0;
        for (char character : sortedCharacters) {
            if (character == sortedDocument[docIndex]) {
                if (docIndex == sortedDocument.length - 1) {
                    return true;
                }
                docIndex++;
            }
        }
        return false;
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 2-----

//  On this solution we create a HashMap for each character on the given character string and how many times it appears.
//  Then we go through the given document String and check if all its characters are in the HashMap.
//  - Time complexity is O(C*(N+M)), where C is the number of unique characters in the document, N is the length of
//  "characters", and M is the length of "document".
//  - Space complexity is.
    public static boolean hashMapSolution(String characters, String document) {

        HashMap<Character, Integer> charCount = new HashMap<>();

        // adding all characters to the HashMap structure
        for (int i=0; i < characters.length(); i++) {
            char currentChar = characters.charAt(i);
            charCount.putIfAbsent(currentChar, 0);
            charCount.put(currentChar, charCount.get(currentChar) + 1);
        }

        // checking if document characters fit in tge HashMap structure
        for (int i=0; i< document.length(); i++) {
            char currentChar = document.charAt(i);
            if (!charCount.containsKey(currentChar) || charCount.get(currentChar) == 0) {
                return false;
            }
            charCount.put(currentChar, charCount.get(currentChar) - 1);
        }
        return true;
    }
}