package com.adv.linkedlist.additional;

public class RemoveNthNodefromListEnd {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;

        removeNthFromEnd(one,2);


    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int cnt = 0; int i = 1;
        ListNode temp = A;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        cnt = cnt - B +1;

        temp = A;
        while (temp != null && i < cnt-1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;

        return A;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
