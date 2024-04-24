package mockPre.day7_linkedlist;

import java.util.ArrayList;
import java.util.HashSet;


public class RemoveLoopFromLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);

        root.next = root2;
        root2.next = root3;
        root3.next = root2;
        solve(root);


    }

    // https://www.scaler.com/academy/mentee-dashboard/class/155287/assignment/problems/4226
    public static ListNode solve(ListNode A) {
        if(A==null && A.next == null ) return A;
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = A;
        while(temp !=null) {
            set.add(temp);
            if(temp.next !=null && set.contains(temp.next)) {
                temp.next = null;
                return A;
            }
            temp = temp.next;
        }
        return A;
    }
}