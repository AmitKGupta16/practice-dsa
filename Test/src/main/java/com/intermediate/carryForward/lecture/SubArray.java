package com.intermediate.carryForward.lecture;

public class SubArray {
    //SubArray formula of N length array= N*(N+1)/2;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int N= arr.length;
        for(int start =0;start<N;start++){
            for(int end = start;end<N;end++) {
                for(int idx=start;idx <= end;idx++) {
                    System.out.print(arr[idx]);
                }
                System.out.println();
            }
        }
    }
}
