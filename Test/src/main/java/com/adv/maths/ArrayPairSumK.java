package com.adv.maths;

import java.util.HashSet;

public class ArrayPairSumK {
    public static boolean solve(int[] A, int K) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<A.length;i++) {
            if(hs.contains(K-A[i])) {
                return true;
            }
            hs.add(A[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {5,8,2,-3,0,-3},4));
    }
}
