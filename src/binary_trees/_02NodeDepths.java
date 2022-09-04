/*
The distance between a node in a Binary Tree and the tree's root is called the node's depth. Write a function that takes
in a Binary Tree and return the sum of its nodes' depths.

Each BinaryTree node has an integer value, a left child node, and a right child node. Children node can either be a Bi-
naryTree nodes themselves or null.

Simple input:
tree =    1
        /  \
       2    3
      / \  / \
     4  5 6   7
    / \
   8   9

Sample output: 16
 */
package binary_trees;

import binary_trees.helper.BinaryTree;

public class _02NodeDepths {
    public static void main(String[] args) {
    }

    private static int nodeDepths(BinaryTree root) {
        return getNodeDepth(root,0);
    }

    private static int getNodeDepth(BinaryTree node, int depth) {
        if (node == null) return 0;
        return depth + getNodeDepth(node.left, depth + 1) + getNodeDepth(node.right, depth + 1);
    }
}
