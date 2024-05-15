package com.adv.binarySearch.binarySearch1.assignment.lecture;

//Find peak element in increasing decreasing array.
public class FindPeakElement {
    public static void main(String[] args) {
        int[] A = {1, 3, 8, 10, 7, 4};
        System.out.println(solve(A));

    }

    public static int solve(int[] A) {

        int start = 0, end = A.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if ((mid == 0 || A[mid] > A[mid - 1]) && (mid == A.length - 1 || A[mid] > A[mid + 1])) {
                return A[mid];
            }
            if (mid == 0 || A[mid] > A[mid - 1]) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return A[mid];

    }


}
