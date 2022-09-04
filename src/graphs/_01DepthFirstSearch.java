/*
You're given a Node class that has a name and an array of optional children nodes. When put together, nodes form an a-
cyclic tree-like structure.

Implement the depthFirstSearch method on the Node class, which takes in an empty array, traverses the tree using the
Depth-first Search approach* (specifically navigating the tree from left to right), stores all of the nodes' names in
the input array, and returns it.

SAMPLE INPUT
graph =   A
         /|\
        B C D
       /\   /\
      E F  G H
       / \  \
      I   J  K

SAMPLE OUTPUT
["A","B","E","F","I","J","C","D","G","K","H"]
 */
package graphs;

import java.util.ArrayList;
import java.util.List;

public class _01DepthFirstSearch {
    public static void main(String[] args) {

    }

//  Time complexity is O(N) where N is the sum of the graph's vertices(nodes) + edges(connections between nodes)
//  Space complexity is O(N) where N is the amount of vertices/nodes, because of the call stack of the recursive function.
    public static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        // This method is the challenge, all the rest was already written.
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (Node node : this.children) {
                node.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

