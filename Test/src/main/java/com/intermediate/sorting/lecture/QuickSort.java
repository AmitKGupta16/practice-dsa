package com.intermediate.sorting.lecture;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {5, 7, 1, 4, 6, 8, 2};
        //5 2 1 4 6 8 7
        //
        quickSort(A, 0, A.length - 1);
        System.out.println();
    }

    public static int partition(int[] A, int start, int end) {

        int pivot = A[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            if (A[left] <= pivot) left++;
            else if (A[right] > pivot) right--;
            else {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        int temp =  A[right];
        A[right] = A[start];
        A[start] = temp;
        return right;
    }

    public static void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int pivotIdx = partition(A, start, end);
        quickSort(A, start, pivotIdx - 1);
        quickSort(A, pivotIdx + 1, end);
        //    }

    }
}
