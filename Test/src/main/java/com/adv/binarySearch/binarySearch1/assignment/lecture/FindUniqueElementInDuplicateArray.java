package com.adv.binarySearch.binarySearch1.assignment.lecture;

//Given a sorted array where every element appear twice except for one element that appears one time,
//find that unique element.
public class FindUniqueElementInDuplicateArray {
    public static void main(String[] args) {
        int[] A = {2, 2, 5, 7, 7, 8, 8};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int start = 0, end = A.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((mid == 0 || A[mid] != A[mid - 1]) && (mid == A.length - 1 || A[mid] != A[mid + 1])) {
                return A[mid];
            }
            int ti=0;
            if(A[mid] ==A[mid-1]) {
                ti = mid-1;
            } else {
                ti = mid;
            }
            if(ti %2 ==0) {
                start = mid+1;
            }else end = mid-1;
        }
        return A[mid];
    }
}
