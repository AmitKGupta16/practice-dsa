package com.adv.linkedlist.lecture;

import com.adv.linkedlist.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(2);
        ListNode D = new ListNode(1);
        A.next = B;
        B.next = C;
        C.next = D;
        System.out.println(palindrome(A));

    }

    public static boolean palindrome(ListNode A){

        ListNode curr=null,prev=null,next=null,temp;
        boolean palnidrome = false;

        curr = cloneListNode(A);
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp = A;
        while(prev !=null && temp!=null) {
            if(prev.val == temp.val) {
                prev=prev.next;
                temp=temp.next;
                palnidrome = true;
            } else {
                palnidrome = false;
                break;
            }
        }
        return palnidrome;


/*        int size=0,mid =0;
        ListNode first,firstH=null, second,temp;
        temp =A;
        while(temp!=null) {
            size++;
            temp= temp.next;
        }
        mid = size %2 ==0 ? size/2: (size+1)/2;
        temp =A;
        while(temp!=null && mid > 0) {
            if(firstH==null) firstH = temp;
            first = temp;
            temp= temp.next;
            first = temp.next;
            mid--;
        }*/
    }

    public static ListNode cloneListNode(ListNode A) {
        if (A == null) return null;
        ListNode head = new ListNode(A.val);
        ListNode copyHead = head;
        ListNode temp = A.next;
        while (temp != null) {
            head.next = new ListNode(temp.val);
            head = head.next;
            temp = temp.next;
        }
        return copyHead;
    }
}
