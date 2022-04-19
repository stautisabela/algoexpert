package greedy_algorithms;

import java.util.Arrays;
import java.util.Collections;

public class _03TandemBicycle {
    public static void main(String[] args) {
        System.out.println(tandemBicycle(new int[]{5, 5, 3, 9, 2}, new int[] {3, 6, 7, 2, 1}, true));

    }

    private static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int totalSpeed = 0;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (fastest == true) {
            reverseArray(blueShirtSpeeds);
        }

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return totalSpeed;
    }

    private static void reverseArray(int[] array) {
        int startPointer = 0;
        int endPointer = array.length-1;
        int temp;

        while (startPointer < endPointer) {
            temp = array[endPointer];
            array[endPointer] = array[startPointer];
            array[startPointer] = temp;

            startPointer++;
            endPointer--;
        }
    }
}
