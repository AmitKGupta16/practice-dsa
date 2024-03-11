package com.adv.linkedlist.lecture;

import com.adv.linkedlist.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next= E;
        System.out.println(reorderList(A));
    }
    public static ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) return A;
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int secondHalf = (size + 1) / 2;
        ListNode current = A;
        int jumpCount = secondHalf;
        while (jumpCount > 0) {
            current = current.next;
            jumpCount--;
        }
        ListNode secondHalfReversed = reverseList(current);
        temp = A;
        ListNode res = new ListNode(0);
        ListNode reshead = res;

        jumpCount = secondHalf;
        while (temp != null && secondHalfReversed != null && jumpCount > 1) {
            res.next = new ListNode(temp.val);
            res = res.next;
            res.next = new ListNode(secondHalfReversed.val);
            temp = temp.next;
            secondHalfReversed = secondHalfReversed.next;
            res = res.next;
            jumpCount--;
        }
        if(size %2 !=0) {
            res.next = new ListNode(temp.val);
        }
        return reshead.next;

    }
    public static ListNode reverseList(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode current = A;
        ListNode next, prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
