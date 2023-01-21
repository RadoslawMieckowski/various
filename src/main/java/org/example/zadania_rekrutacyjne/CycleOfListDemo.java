package org.example.zadania_rekrutacyjne;

import java.util.HashSet;
import java.util.Set;

public class CycleOfListDemo {
    public static void main(String[] args) {
        Node node1A = new Node(1);
        Node node2A = new Node(2);
        Node node3A = new Node(3);
        Node node4A = new Node(4);
        Node node5A = new Node(5);

        Node node1B = new Node(1);
        Node node2B = new Node(2);
        Node node3B = new Node(3);
        Node node4B = new Node(4);
        Node node5B = new Node(5);

//        cyclic list
        node1A.next = node2A;
        node2A.next = node3A;
        node3A.next = node4A;
        node4A.next = node5A;
        node5A.next = node1A;

//        acyclic list
        node1B.next = node2B;
        node2B.next = node3B;
        node3B.next = node4B;
        node4B.next = node5B;

        boolean isCyclicA = isCyclic(node1A);
        boolean isCyclicB = isCyclic(node1B);
        System.out.println(isCyclicA);
        System.out.println(isCyclicB);

        boolean isCyclic2A = isCyclic2(node1A);
        boolean isCyclic2B = isCyclic2(node1B);
        System.out.println(isCyclic2A);
        System.out.println(isCyclic2B);
//        Node node = node5B.next.next.next.next.next;  daje nulllPointerException
    }


    // slowPointer też powinie się ruszać, bo jeżeli byłby nieruchomy a cykl byłby gdzie indziej, to nigdy by sie nie spotkał z fastPointerem
    private static boolean isCyclic(Node node) {
        if (node == null) {
            return false;
        }
        Node pointerFast = node;
        Node pointerSlow = node;
        while (pointerFast != null && pointerFast.next != null) { //ze względu na parzystą i nieparzystą liczbe el w liscie i
              //zabezpieczenie przed NullPointerException
            pointerFast = pointerFast.next.next;
            pointerSlow = pointerSlow.next;
            if (pointerFast == pointerSlow) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclic2(Node node) {
        Set<Node> mapOfVisitedNodes = new HashSet<>();
        while (node != null) {
            if (mapOfVisitedNodes.contains(node)) {
                return true;
            }
            mapOfVisitedNodes.add(node);
            node = node.next;
        }
        return false;
    }
}
