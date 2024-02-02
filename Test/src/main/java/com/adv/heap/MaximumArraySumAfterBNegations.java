package com.adv.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumArraySumAfterBNegations {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(57,3,-14,-87,42,38,31,-7,-28,-61));
        int res=solve(A,10);
        System.out.println(res);
    }
    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : A) {
            minHeap.add(val);
        }
        int sumB = 0;
        for (int i = 0; i < B; i++) {
            int min = minHeap.poll();
            minHeap.add(-min);
          //  sumB += -min;
        }

        while(!minHeap.isEmpty()) sumB+=minHeap.poll();

        return sumB;

    }
}
