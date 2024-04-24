package com.adv.heap.heap2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(59,64,10,39));
        solve(list);
    }
    /*
    *
    *
    *
    *
    * */
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            int currMax = maxHeap.isEmpty() ? Integer.MAX_VALUE : maxHeap.peek();
            if (A.get(i) <= currMax) maxHeap.add(A.get(i));
            else minHeap.add(A.get(i));
            int diff = maxHeap.size() - minHeap.size();
            if (diff > 1 || diff < 0)
                if (diff > 1)
                    minHeap.add(maxHeap.poll());
                else
                    maxHeap.add(minHeap.poll());
            //output.add(((maxHeap.size() + minHeap.size()) % 2 != 0) ? maxHeap.peek() : maxHeap.peek() );
            output.add(maxHeap.peek());
        }

        return output;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, i1 = 0, i2 = 0;
        int l = nums1.length + nums2.length;
        int[] a = new int[(l / 2) + 1];
        while (i < a.length) {
            if (i1 < nums1.length && i2 < nums2.length) {
                a[i++] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
            } else if (i1 < nums1.length) {
                a[i++] = nums1[i1++];
            } else {
                a[i++] = nums2[i2++];
            }
        }
        if (l % 2 == 1) {
            return a[a.length - 1];
        } else {
            double t = (a[a.length - 2] + a[a.length - 1]);
            return t / 2.00;
        }
    }
}
