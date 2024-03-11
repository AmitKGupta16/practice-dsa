package com.intermediate.prefixsum.lecture;

public class EquilibriumIndex {
    public static void main(String[] args) {

    }
    private int[] prefixSum(int[] A) {
        int N = A.length;
        int[] pf = new int[N];
        pf[0] = A[0];
        for(int idx= 1; idx<N;idx++) {
            pf[idx] = pf[idx-1] + A[idx];
        }
        return pf;
    }
    public int solve(int[] A) {
        int N = A.length;
        int[] pf = prefixSum(A);
        int leftSum=0,rightSum=0;
        //se = arse(0,i-1) + arso(i+1,N-1), check start index =0
        // 0, i-1, i+1, n-1
        //0 ->  L(0,0-1) - R(0+1->n-1)
        //1 ->  L(0,1-1) - R(1+1->n-1)
        //2->   L(0,2-1) - R(2+1->n-1)....

        for(int idx =0; idx <N; idx++) {
           if(idx==0) {
               leftSum =0;
           } else {
               leftSum = pf[idx-1];
           }
           //0 - idx-1 , idx+1 -N-1
           //leftSum = idx-1 > 0 ? pf[idx-1]:0;
           rightSum = pf[N-1] - pf[idx];
           if(leftSum == rightSum) return idx;


        }
        return -1;

    }
}
