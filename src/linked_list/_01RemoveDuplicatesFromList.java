package linked_list;

import java.util.LinkedList;

public class _01RemoveDuplicatesFromList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(6);

        System.out.println(removeDuplicates(list));
    }

    private static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {

        for (int i=1; i < list.size(); i++) {
            if (list.get(i) == list.get(i-1)) {
                list.remove(i);
            }
        }
        return null;
    }

}
/*
You're given the head of a Singly Linked List whose nodes are in sorted order with respect to their values. Write a
function that returns a modified version of the Linked List that doesn't contain any nodes with duplicate values. The
Linked List should be modified in place (i.e., you shouldn't create a brand new list), and the modified Linked List
should still have its nodes sorted with respect to their values.
 */
