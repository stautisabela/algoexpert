package strings;

import java.util.Arrays;
import java.util.HashMap;

public class _04GenerateDocument {
    public static void main(String[] args) {
        System.out.println(canGenerateDocument("z xncc*vb  bKnkm", "c*vk bxKn"));
    }

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
/*
You're given a string of available characters and a string representing a document that you need to generate. Write a
function that determines if you can generate the document using the available characters. If you can generate the
document, your function should return true; otherwise, it should return false.
 */