package contest_tree_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FlipkartInventry {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Profit> list = new ArrayList<>();
        for (int i=0;i<A.size();i++) {
            list.add(new Profit(A.get(i),B.get(i)));
        }
        list.sort(Comparator.comparingInt(val-> val.duration));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int time= 0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i).duration > time) {
                minHeap.add(list.get(i).profit);
                time++;
            }else {
                if(list.get(i).profit > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(list.get(i).profit);
                }
            }
        }
        int totalSum =0 ;
        while(!minHeap.isEmpty()) {
            totalSum += minHeap.poll();
        }
        return totalSum;
    }
}
class Profit {
    int duration;
    int profit;
    public Profit (int duration, int profit) {
        this.profit = profit;
        this.duration = duration;
    }
}

