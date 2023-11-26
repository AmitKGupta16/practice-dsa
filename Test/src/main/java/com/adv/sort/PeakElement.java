package com.adv.sort;

public class PeakElement {
    public static int solve(int[] A) {
        int N = A.length;
        int s=0,e= N-1;
        int mid=0;
        while(s<=e) {
            mid = (s+e)/2;
            if((mid==0 || A[mid] > A[mid-1]) && (mid==N-1 || A[mid] > A[mid+1])) {
                return A[mid];
            }
            if(mid==0 || A[mid-1] < A[mid]) {
                s= mid+1;
            } else {
                e = mid-1;
            }
        }
        return A[mid];
    }

    public static void main(String[] args) {
        solve(new int[] {1,2,3,4,5});
    }
}
