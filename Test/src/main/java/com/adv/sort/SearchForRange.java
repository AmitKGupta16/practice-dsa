package com.adv.sort;

public class SearchForRange {
    public static int[] searchRange(final int[] A, int B) {
        int[] res= new int[2];
        int first=-1;
        int last=-1;
        int s=0, e = A.length-1;
        int mid=0;
        while(s < e) {
            mid = (s+e)/2;
            if((mid==0 || B > A[mid-1]) && A[mid] == B) {
                first = mid;
            }
//            if((mid==A.length-1 || B < A[mid+1]) && A[mid] == B) {
//                last = mid;
//            }
            else if(B > A[mid]) {
                s = mid+1;
            } else {
                e= mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        searchRange(new int[] {5, 7, 7, 8, 8, 10},8);

    }
}
