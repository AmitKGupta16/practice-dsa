package com.adv.heap.heap1.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Problem Description
        Given a list containing head pointers of N sorted linked lists.
        Merge these given sorted linked lists and return them as one sorted list.



        Problem Constraints
        1 <= total number of elements in given linked lists <= 100000



        Input Format
        The first and only argument is a list containing N head pointers.



        Output Format
        Return a pointer to the head of the sorted linked list after merging all the given linked lists.



        Example Input
        Input 1:

        1 -> 10 -> 20
        4 -> 11 -> 13
        3 -> 8 -> 9
        Input 2:

        10 -> 12
        13
        5 -> 6


        Example Output
        Output 1:

        1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
        Output 2:

        5 -> 6 -> 10 -> 12 ->13


        Example Explanation
        Explanation 1:

        The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
        Explanation 2:

        The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.*/
public class MergeKSortedLists {
    public static void main(String[] args) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode one_1=  new ListNode(4);
        ListNode one_2=  new ListNode(6);
        one_1.next = one_2;
        list.add(one);
        list.add(one_1);
        mergeKLists(list);


    }
    public static ListNode mergeKLists(ArrayList<ListNode> A) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(val -> val.val));
        minHeap.addAll(A);
        ListNode output = new ListNode(0);
        ListNode temp =  output;
        while (!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            if (poll.next !=null) minHeap.add(poll.next);
            temp.next = new ListNode(poll.val);
            temp = temp.next;
        }
        return output.next;
    }

    public static ArrayList<Integer> mergeLists(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ArrayList<Integer> list : A) {
            for(Integer val : list) {
                minHeap.add(val);
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            Integer val = minHeap.poll();
            output.add(val);
        }
        return output;

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
