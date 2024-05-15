package com.adv.binarySearch.binarySearch1.assignment.lecture;

// Find the first occurrence of an element in a sorted array. (With duplicate values)
public class FirstOccuranceOfElementInDuplicateArray {

    public static void main(String[] args) {
        int[] A = {2,2, 5, 5,5,5,8,10,10,13};
        System.out.println(solve(A,10));
    }

    public static int solve (int[] A, int B) {
        int start = 0, end = A.length-1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end-start)/2;

            if(A[mid] == B && (mid ==0 || A[mid] > A[mid-1])) {
                return mid;
            }
            if(A[mid] <= B) start = mid +1;
            else end = mid -1;

        }
        return -1;

    }
}
