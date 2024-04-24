package contest_tree_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(ArrayList<Integer> A) {
        int size= A.size();
        if(size==1 ) return A.get(0);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int totalSum =0;
        while(!minHeap.isEmpty() && minHeap.size() > 1) {
            int sum = minHeap.poll() + minHeap.poll();
            totalSum += sum;
            minHeap.add(sum);
        }
        return totalSum;

    }
}
