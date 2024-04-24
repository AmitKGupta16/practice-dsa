package com.intermediate.sorting.lecture;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {5,6,1,3,7,8};
        sort(arr);
        System.out.println();

    }
    public static void sort(int[] arr) {
        int length = arr.length;
        for(int i =0; i<length-1;i++) {
            int min_ele = Integer.MAX_VALUE;
            int min_idx = -1;
            for(int j=i;j<length;j++) {
                if(arr[j] < min_ele ) {
                    min_ele = arr[j];
                    min_idx = j;
                }
            }
            swap(arr, i, min_idx);
        }
    }

    public static void swap(int[] arr, int startIdx, int endIdx) {
        int temp = arr[startIdx];
        arr[startIdx] = arr[endIdx];
        arr[endIdx] = temp;
    }
}
