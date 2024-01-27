package com.intermediate.array.lecture;

public class MaxElementInArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(solve(A));
        System.out.println(solve1(A));
    }
    public static int solve(int[] A) {
        int N = A.length;
        int max = A[0];
        for(int i=1;i<N;i++ ) {
            if(max < A[i]){
                max = A[i];
            }
        }
        return max;
    }

    //optimized

    public static int solve1(int[] A) {
        int max= Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            if(max < A[i]){
                max =A[i];
            }
        }
        return max;
    }
}
