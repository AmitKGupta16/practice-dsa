package com.adv.linkedlist.linkedlist1.lecture;

import com.adv.linkedlist.ListNode;

public class LinkedListOperations {
    public static void main(String[] args) {

    }

    public ListNode insertNodeAtKthPosition(ListNode head, int pos, int val) {
        ListNode newNode = new ListNode(val);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        ListNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp= temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public ListNode deleteNode(ListNode head, int x) {
        if(head == null) return  null;
        if(head.val == x) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        while(temp!= null && temp.next !=null) {
            if(temp.next.val == x) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
