/*
You're given the head of a Singly Linked List whose nodes are in sorted order with respect to their values. Write a
function that returns a modified version of the Linked List that doesn't contain any nodes with duplicate values. The
Linked List should be modified in place (i.e., you shouldn't create a brand new list), and the modified Linked List
should still have its nodes sorted with respect to their values.

Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None/null
if it's the tail of the list.
 */
package linked_list;

import linked_list.utils.LinkedList;

public class _01RemoveDuplicatesFromList {
    public static void main(String[] args) {

    }



//  On this solution we traverse LinkedList and check the current node and the next node values, if they are the same,
//  we replace the pointer for the next node, skipping it.
//  - Time complexity is O(N) where N is the length of the list.
//  - Space complexity is O(1).
    private LinkedList removeDuplicates(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            if(currentNode.next != null && currentNode.value == currentNode.next.value) {
                currentNode.next = currentNode.next.next;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return linkedList;
    }
}
