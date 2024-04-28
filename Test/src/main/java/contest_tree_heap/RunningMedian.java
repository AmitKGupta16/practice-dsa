package contest_tree_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        if(A==null || A.isEmpty()) return output;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            int curr = maxHeap.peek() == null ? Integer.MAX_VALUE:maxHeap.peek();
            if(A.get(i) <= curr) maxHeap.add(A.get(i));
            else minHeap.add(A.get(i));
            int diff = maxHeap.size() - minHeap.size();
            if (diff > 1) minHeap.add(maxHeap.poll());
            else if(diff < 0) maxHeap.add(minHeap.poll());
            output.add(maxHeap.poll());
        }
        return output;
    }
}
