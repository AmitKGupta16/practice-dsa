package contest_tree_heap;

import com.adv.linkedlist.ListNode;

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> A) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(val -> val.val));
        minHeap.addAll(A);
        ListNode output = new ListNode(0);
        ListNode  temp = output;
        while(!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            if(poll.next != null) minHeap.add(poll.next);
            temp.next = new ListNode(poll.val);
            temp = temp.next;
        }
        return output.next;

    }
}
