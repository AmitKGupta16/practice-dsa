package com.intermediate.array.lecture;

public class ReversePartOfArray {
    public static void main(String[] args) {
        int[] A= {1,2,3,4,5,6};
        //output : 1 2 5 4 6
        int l=2,r=4;
        solve(A,l,r);
        for(int val:A) System.out.print(val + " ");

    }

    //Optimized Approach
    public static void solve(int[] A, int l, int r){
        int i=l,j=r;
        int temp=0;
        while(i<j){
            temp = A[i];
            A[i] = A[j];
            A[j] =  temp;
            i++;j--;
        }
    }
}
