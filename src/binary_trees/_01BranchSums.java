/*
Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost branch sum to
rightmost branch sum.

A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree branch is a path of nodes in a tree that
starts at the root and ends at any leaf node.

Each BinaryTree node has an integer value, a left child node, and a right child node. Children nodes can either be Bi-
naryTree nods themselves or none/null.
 */
package binary_trees;

import java.util.ArrayList;
import java.util.List;

public class _01BranchSums {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1, new BinaryTree(2, null, null), new BinaryTree(3, null, null));
        BinaryTree bt2 = new BinaryTree(1, new BinaryTree(2, null, null), null);
        branchSums(bt2);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


/*
- Time complexity is O(N) where N is the total amount of nodes in the tree, because we have to traverse all nodes to
account for their values when we're calculating the branch sums.
- Space complexity is O(N) where N is the , it's affected by the amount of branch sums we have to add to the list and
the call stack of the recursive function
 */
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSum(root, sums, 0);
        System.out.println(sums);
        return sums;
    }
    private static void calculateBranchSum(BinaryTree node, List<Integer> sums, int currentSum) {

    }
}