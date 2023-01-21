package org.example.zadania_rekrutacyjne;

public class ReverseListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(node1);

        Node newHead = reverseList(node1);

        System.out.println(newHead);
    }

    private static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}

class Node {
     Node next;
     int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", node=" + next +
                '}';
    }
}
