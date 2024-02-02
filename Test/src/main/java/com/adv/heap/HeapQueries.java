package com.adv.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapQueries {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> list : A) {
            if (list.get(0) == 1 )
                res.add(minHeap.isEmpty()?-1:minHeap.poll());
            else
                minHeap.add(list.get(1));
        }
        return res;
    }
}
