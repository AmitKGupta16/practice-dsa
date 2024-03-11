package com.adv.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ConstructLinkedList {

    public static ListNode constructLinkedList(List<Integer> list)  {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for(Integer val : list) {
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
        }
        return head;
    }
}
