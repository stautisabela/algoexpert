/*
Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns the closest value to
that target value contained in the BST

You can assume that there will only be one closest value

Each BST node had an integer value, a left child node, and a right child node. A node is said to be a valid BST node if
and only if it satisfies the BST properly: its value is strictly greater than the values of every node to its left; its
value is less than or equal to the values of every node to its right; and its children nodes are either valid BST nodes
themselves or None/null.

Ex.
target = 12
tree =   10
        /  \
       5    15
      / \  /  \
     2  5 13  22
    /      \
   1       14

output = 13
 */
package binary_search_trees;

public class _01FindClosestValueInBST {
    public static void main(String[] args) {
    }

    private static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 1-----

//  - Time complexity is O(log(N)) on average, where N is the number of nodes in the tree. We eliminate on an average
//  half the tree on each function call. The worst case scenario has a complexity of O(N), when the tree has one branch
//  only.
//  - Space complexity is O(log(N)) on average, because it's a recursive solution that keeps a call stack. If the tree
//  has one branch only, complexity will be O(N).
    private static int recursiveFindClosestValue(BST tree, int target) {
        return findClosestValueHelper(tree, target, tree.value);
    }

    private static int findClosestValueHelper(BST tree, int target, int closestNo) {
        if (Math.abs(tree.value - target) < Math.abs(closestNo - target)) {
            closestNo = tree.value;
        }

        if (tree.value > target && tree.left != null) {
            return findClosestValueHelper(tree.left, target, closestNo);
        }
        else if (tree.value < target && tree.right != null) {
            return findClosestValueHelper(tree.right, target, closestNo);
        }
        return closestNo;
    }



//-------------------------------------------------------------------------------------------------------SOLUTION 2-----

//  - Time complexity is O(log(N)) on average, where N is the number of nodes in the tree. We eliminate on an average
//  half the tree on each function call. The worst case scenario has a complexity of O(N), when the tree has one branch
//  only.
//  - Space complexity is always O(1) because it's iterative instead of recursive.
    private static int iterativeFindClosestValue(BST tree, int target) {
        BST currentNode = tree;
        int closestNo = tree.value;
        while (currentNode != null) {
            if (Math.abs(currentNode.value - target) < Math.abs(closestNo - target)) {
                closestNo = currentNode.value;
            }

            if (currentNode.value > target) {
                currentNode = currentNode.left;
            }
            else if (currentNode.value < target) {
                currentNode = currentNode.right;
            }
            else break;
        }
        return closestNo;
    }
}
