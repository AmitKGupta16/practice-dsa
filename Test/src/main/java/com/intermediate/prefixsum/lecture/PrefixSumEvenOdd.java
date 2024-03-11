package com.intermediate.prefixsum.lecture;

import test.AdjancyList;

public class PrefixSumEvenOdd {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] pfEven = pfEven(A);
        for (int idx = 0; idx < A.length; idx++) {
            System.out.print(pfEven[idx] + " ");
        }
        System.out.println();
        int[] pfOdd = pfOdd(A);
        for (int idx = 0; idx < A.length; idx++) {
            System.out.print(pfOdd[idx] + " ");
        }
    }

    public static int[] pfEven(int[] A) {
        int[] pfEven = new int[A.length];
        pfEven[0] = A[0];
        for (int idx = 1; idx < A.length; idx++) {
            if (idx % 2 == 0) {
                pfEven[idx] = pfEven[idx - 1] + A[idx];
            } else {
                pfEven[idx] = pfEven[idx - 1];
            }
        }
        return pfEven;
    }

    public static int[] pfOdd(int[] A) {
        int[] pfOdd = new int[A.length];
        pfOdd[0] =0;
        for(int idx = 1; idx < A.length; idx++) {
            if(idx % 2 == 0) {
                pfOdd[idx] = pfOdd[idx-1];
            } else {
                pfOdd[idx] = pfOdd[idx-1] + A[idx];
            }
        }
        return pfOdd;
    }
}
