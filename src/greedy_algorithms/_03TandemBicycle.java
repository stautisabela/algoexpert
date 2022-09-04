/*
A tandem bicycle is a bicycle that operated bw two people: person A and person B. Both people pedal the bicycle, but the
person that pedals faster dictates the speed of the bicycle. So if person A pedals at a speed of 5, and person B pedals
at a peed of 4, the tandem bicycle moves at a speed of 5.

You're given two lists of positive integers: one that contains the speeds of riders wearing red shirts and one that con-
tains the speeds of riders wearing blue shirts. Each rider is represented by a single positive integer, which is the
speed that they pedal a tandem bicycle at. Both lists have the same length, meaning that there are as many red-shirt
riders as there are blue-shirt riders. Your goal is to pair every rider wearing a red shirt with a rider wearing a blue
shirt to operate a tandem bicycle.

Write a function that returns the maximum possible total speed or the minimum possible total speed of all of the tandem
bicycles being ridden based on an input parameter, fastest. If fastest = true, your function should return the maximum
possible total speed; otherwise it should return the minimum total speed.

Total speed is defined as the sum of the speeds of all the tandem bicycles being ridden. For example, if there are 4
riders (2 red-shirt riders and 2 blue-shirt riders) who have speeds of 1, 3, 4, 5, and if they're paired on tandem bi-
cycles as follows: [1, 4], [5, 3], then the total speed of these tandem bicycles is 4 + 5 = 9.

SAMPLE INPUT
redShirtSpeeds=[3, 5, 3, 9, 3]
blueShirtSpeeds=[3, 6, 7, 2, 1]
fastest=true

SAMPLE OUTPUT
32
 */
package greedy_algorithms;

import java.util.Arrays;
import java.util.Collections;

public class _03TandemBicycle {
    public static void main(String[] args) {
        System.out.println(tandemBicycle(new int[]{5, 5, 3, 9, 2}, new int[] {3, 6, 7, 2, 1}, true));

    }

//  On this solution we'll sort both arrays so we can we pair the riders in ascendant or descendant order, depending on
//  the value of fastest.
//  - Time complexity is O(log(N)) where N is the length of the arrays, because we're sorting them.
//  - Space complexity is O(1).
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
