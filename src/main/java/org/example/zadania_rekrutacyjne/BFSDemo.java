package org.example.zadania_rekrutacyjne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDemo {
    public static void main(String[] args) {
        TNode node1 = new TNode(1);
        TNode node2 = new TNode(2);
        TNode node3 = new TNode(3);
        TNode node4 = new TNode(4);
        TNode node5 = new TNode(5);
        TNode node6 = new TNode(6);
        TNode node7 = new TNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

//        System.out.println(node1);

        System.out.println(BFS(node1));

    }

    private static List<Integer> BFS(TNode node) {
        if (node != null) {
            Queue<TNode> queue = new LinkedList<>();
            List<Integer> visitedNodes = new ArrayList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                TNode currentNode = queue.remove();
                visitedNodes.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            return visitedNodes;
        } else {
            return null;
        }
    }
}

class TNode {
    TNode right;
    TNode left;
    int value;

    public TNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TNode{"
                + "value=" + value + " "
                + "left=" + left + " "
                + "right=" + right + "}";
    }
}
