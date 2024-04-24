package mockPre.day7_linkedlist;

// https://www.scaler.com/academy/mentee-dashboard/class/155287/assignment/problems/4370
public class MiddleElementInLinkedList {

    public int solve(ListNode A) {
        if (A == null  || A.next ==null ) {
            return 0;
        }
        ListNode slow=A,fast = A;

        while(fast !=null && fast.next !=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }


}
