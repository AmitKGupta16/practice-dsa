package com.adv.linkedlist.linkedlist1.additional;

/*Problem Description
        Reverse a linked list A from position B to C.

        NOTE: Do it in-place and in one-pass.



        Problem Constraints
        1 <= |A| <= 106

        1 <= B <= C <= |A|



        Input Format
        The first argument contains a pointer to the head of the given linked list, A.

        The second arugment contains an integer, B.

        The third argument contains an integer C.



        Output Format
        Return a pointer to the head of the modified linked list.



        Example Input
        Input 1:

        A = 1 -> 2 -> 3 -> 4 -> 5
        B = 2
        C = 4

        Input 2:

        A = 1 -> 2 -> 3 -> 4 -> 5
        B = 1
        C = 5


        Example Output
        Output 1:

        1 -> 4 -> 3 -> 2 -> 5
        Output 2:

        5 -> 4 -> 3 -> 2 -> 1


        Example Explanation
        Explanation 1:

        In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
        Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
        Explanation 2:

        In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
        Thus, the output is 5 -> 4 -> 3 -> 2 -> 1*/

import com.adv.linkedlist.ConstructLinkedList;
import com.adv.linkedlist.ListNode;

import java.util.List;

public class ReverseLinkList_II {
    public static void main(String[] args) {
        ListNode head = ConstructLinkedList.constructLinkedList(List.of(1,2,3,4,5));
        head = head.next;
        reverseBetween(head,2,4);

    }
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode head1= A;
        ListNode temp1 = head1;
        for(int i=1;i<B-1;i++) {
            temp1 = temp1.next;
        }
        ListNode head2 =null;
        if(B==1) {
            head2 = head1;
            head1=null;
        } else {
            head2 = temp1.next;
            temp1.next = null;
        }

        ListNode temp2=  head2;

        for(int i=B;i<C;i++) {
            temp2 = temp2.next;
        }
//
//        ListNode head3 = temp2.next;
//        temp2.next =null;
        ListNode head3 =null;
        if(temp2 !=null) {
            head3 = temp2.next;
            temp2.next =null;
        }

        head2 = reverse(head2);

        ListNode temp4 = head1;
        while( temp4  != null && temp4.next !=null) {
            temp4= temp4.next;
        }
        if(temp4 !=null) {
            temp4.next = head2;
        }

        ListNode temp5 = head2;
        while(temp5.next !=null) {
            temp5 = temp5.next;
        }
        temp5.next= head3;

        return head1 !=null?head1:head2;
    }

    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev=null, next= null;
        while ( temp !=null) {
            next = temp.next;
            temp.next= prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
