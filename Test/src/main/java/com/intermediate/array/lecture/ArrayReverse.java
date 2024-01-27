package com.intermediate.array.lecture;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        solve(A);
        for(int val : A) System.out.println(val);

    }
    //Optimized Approach
    public static void solve(int[] A) {
        int N= A.length;
        int i=0,j=N-1;
        int temp =0;
        while(i<j) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;j--;
        }
    }
}
