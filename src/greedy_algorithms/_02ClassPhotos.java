package greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _02ClassPhotos {
    public static void main(String[] args) {
        long start = System.nanoTime();
        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3,4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));

        boolean result = canTakeClassPhoto(redShirtHeights, blueShirtHeights);
        System.out.println(System.nanoTime() - start);
    }

    private static boolean canTakeClassPhoto(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean redOnTheFront = true;
        boolean blueOnTheFront = true;

        for (int i=0; i < redShirtHeights.size(); i++) {
            if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
                redOnTheFront = false;
            }
            else if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                blueOnTheFront = false;
            }
            if (redOnTheFront == false && blueOnTheFront == false) {
                return false;
            }
        }
        return true;
    }
}
/*
It's photo day at the local school, and you're the photographer assigned to take class photos. The call that you'll be
photographing has an even number of students, and all these students are wearing red or blue shirts. In fact, exactly
half of the class is wearing red shirts, and the other half is wearing blue shirts. You're responsible for arranging the
students in two rows before taking the photo. Each row should contain the same number of students and should adhere to
the following guidelines:
- All students wearing red shirts must be in the same row
- All students wearing blue shirts must be in the same row
- Each student in the back row must be strictly taller than the student directly in front of them in the front row
You're given two input arrays: one containing the heights of all the students with red shirts and another one containing
the heights of all students with blue shirts. These arrays always have the same length, and each height will be a
positive integer. Write a function that returns whether or not a class photo that follows the stated guidelines can be
taken.
 */