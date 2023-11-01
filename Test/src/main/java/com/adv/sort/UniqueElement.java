package com.adv.sort;

import java.util.Arrays;

public class UniqueElement {
    public static int solve(int[] A) {
        int N=A.length;
        Arrays.sort(A);
        int cnt =0;
        for(int i=N-2;i>=0;i--) {
            if(A[i] == A[i+1]){
                A[i+1] = A[i] +1;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,1,3,3}));
    }
}
