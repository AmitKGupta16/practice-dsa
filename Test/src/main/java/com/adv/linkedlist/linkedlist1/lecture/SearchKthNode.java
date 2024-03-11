package com.adv.linkedlist.linkedlist1.lecture;

import com.adv.linkedlist.ConstructLinkedList;
import com.adv.linkedlist.ListNode;

import java.util.List;

public class SearchKthNode {
    public static void main(String[] args) {
        ListNode head = ConstructLinkedList.constructLinkedList(List.of(1,2,3,4));
       // System.out.println(searchKthNode(3,head));
        System.out.println(searchValue(5,head));

    }

    public static int searchKthNode(int k, ListNode head) {
        if(head == null) return -1;
        ListNode temp = head;
        for(int i=0;i<k;i++) {
            temp= temp.next;
        }
        return temp.val;
    }

    public static boolean searchValue(int x, ListNode head) {
        ListNode temp = head;
        while(temp!=null) {
            if(temp.val==x) return true;
            else  temp = temp.next;
        }
        return false;
    }
}
