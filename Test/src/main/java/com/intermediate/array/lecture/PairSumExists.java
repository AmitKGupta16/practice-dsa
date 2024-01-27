package com.intermediate.array.lecture;

/* Given an array of size N. Check if there exists a pair(i,j), such that arr[i]+arr[j] =k
 and i!=j */

public class PairSumExists {
    public static void main(String[] args) {
        int[] A = {9,1,3,5,9};
        //output 9 + 3
        int K = 12;
        System.out.println(solve(A,K));
        System.out.println(solve1(A,K));
    }

    public static boolean solve(int[] A, int K) {
        int N = A.length;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i!=j && A[i] + A[j]==K ) return true;
            }
        }
        return false;
    }

    //optimized Upper triangle approach
    public static boolean solve1(int[] A, int K) {
        int N= A.length;
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                if(A[i]+A[j]==K) return true;
            }
        }
        return false;
    }

}
