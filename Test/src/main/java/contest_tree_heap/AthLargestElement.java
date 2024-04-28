package contest_tree_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AthLargestElement {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        for(int i=0;i<A;i++) {
            minHeap.add(B.get(i));
            if(i <A-1) output.add(-1);
        }
        output.add(minHeap.peek());
        for(int i =A;i<B.size();i++) {
            if(minHeap.peek() < B.get(i)) {
                minHeap.poll();
                minHeap.add(B.get(i));
            }
            output.add(minHeap.peek());
        }
        return output;
    }
}
