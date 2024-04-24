package contest_tree_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(B+1);
        for(int i=0;i<=B;i++) {
            minHeap.add(A.get(i));
        }
        for(int i= B+1;i<A.size();i++) {
            output.add((minHeap.poll()));
            minHeap.add(A.get(i));
        }
        while(!minHeap.isEmpty()) {
            output.add((minHeap.poll()));
        }

        return output;
    }
}
