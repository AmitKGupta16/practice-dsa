package com.adv.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumLargestElement {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(-2,-4,-8,-16));
        solve(input,10);
    }
    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Minimum> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> (o.actualVal + o.currentVal)));
        for(int val : A) {
            minheap.offer(new Minimum(val,val));
        }
        for(int i=0;i<B;i++) {
           Minimum minimum=  minheap.poll();
           minimum.currentVal += minimum.actualVal;
           minheap.add(minimum);
        }
        int max=  Integer.MIN_VALUE;
        while(!minheap.isEmpty()) {
           max=  Math.max(max,minheap.poll().currentVal);

        }
        return max;
    }


}

class Minimum{
    int actualVal;
    int currentVal;
    public Minimum(int actualVal, int currentVal) {
        this.actualVal = actualVal;
        this.currentVal = currentVal;
    }
}
