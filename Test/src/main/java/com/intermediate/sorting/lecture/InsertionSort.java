package com.intermediate.sorting.lecture;

public class InsertionSort {
    public static void main(String[] args) {
        int[] A ={5,7,1,4,6,8,2};
        sort(A);
        System.out.println();

    }

    public static void sort(int[] A) {
        int length = A.length;
        for( int i=1;i<length; i++) {
            int currEle = A[i];
            int j=i-1;
            while(j>=0 && A[j] > currEle) {
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = currEle;
        }
    }
}
