package org.example.zadania_rekrutacyjne;

import java.util.ArrayList;
import java.util.List;

public class DFSDemo {
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

        System.out.println(DFS_Preorder(node1, new ArrayList<>()));
        System.out.println(DFS_Inorder(node1, new ArrayList<>()));
        System.out.println(DFS_Postorder(node1, new ArrayList<>()));
    }

    private static List<Integer> DFS_Preorder(TNode node, List<Integer> visitedNodes) {
        if (node != null) {
            visitedNodes.add(node.value);
            if (node.left != null) {
                DFS_Preorder(node.left, visitedNodes);
            }
            if (node.right != null) {
                DFS_Preorder(node.right, visitedNodes);
            }
            return visitedNodes;
        }
        return null;
    }

    private static List<Integer> DFS_Inorder(TNode node, List<Integer> visitedNodes) {
        if (node != null) {
            if (node.left != null) {
                DFS_Inorder(node.left, visitedNodes);
            }
            visitedNodes.add(node.value);
            if (node.right != null) {
                DFS_Inorder(node.right, visitedNodes);
            }
            return visitedNodes;
        }
        return null;
    }

    private static List<Integer> DFS_Postorder(TNode node, ArrayList<Integer> visitedNodes) {
        if (node != null) {
            if (node.left != null) {
                DFS_Postorder(node.left, visitedNodes);
            }
            if (node.right != null) {
                DFS_Postorder(node.right, visitedNodes);
            }
            visitedNodes.add(node.value);
            return visitedNodes;
        }
        return null;
    }
}

