package com.intermediate.sorting.lecture;

public class MergeSort {
    public static void main(String[] args) {
        int[] A ={5,7,1,4,6,8,2};
        sort(A,0,A.length-1);
        System.out.println();
    }
    public static void sort(int[] A, int start, int end) {
       if (start < end) {
           int mid = start + (end-start)/2;
           sort(A, start, mid);
           sort(A, mid + 1, end);
           merge(A, start, mid, end);
       }
    }

    public static void merge(int[] A, int start, int mid, int end) {
        int[] C = new int[end-start +1];
        int i=start,j = mid+1,k=0;
        while(i<=mid && j <= end) {
            if(A[i] <= A[j]) {
                C[k] = A[i];
                i++;k++;
            } else {
                C[k] = A[j];
                j++;k++;
            }
        }
        while(i<=mid) {
            C[k] =A[i];
            i++;k++;
        }
        while(j<=end) {
            C[k] = A[j];
            j++;k++;
        }
        i=start;k=0;
        while(i<=end) {
            A[i] = C[k];
            i++;k++;
        }
    }

}
