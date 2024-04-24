package com.adv.stack.lecture;

public class StackUsingLinkedList {
    private Node head;
    private int size;

    public StackUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (!isEmpty()) newNode.next = head;
        head = newNode;
        size++;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return head.val;
    }

    public void pop() {
        if (isEmpty()) return;
        head = head.next;
        size--;
    }

    public boolean isEmpty() {
        if (head == null) return true;
        return false;
    }

}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;

    }
}
