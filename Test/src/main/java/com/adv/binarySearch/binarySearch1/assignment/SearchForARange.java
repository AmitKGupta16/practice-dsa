package com.adv.binarySearch.binarySearch1.assignment;

import javax.swing.*;

public class SearchForARange {
/*    Problem Description
    Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

    Return an array of size 2, such that
    First element = Left most index of B in A
    Second element = Right most index of B in A.
    If B is not found in A, return [-1, -1].

    Note : Your algorithm's runtime complexity must be in the order of O(log n).


    Problem Constraints
1 <= N <= 10^6
            1 <= A[i], B <= 10^9


    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.


    Output Format
    Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].


    Example Input
    Input 1:

    A = [5, 7, 7, 8, 8, 10]
    B = 8
    Input 2:

    A = [5, 17, 100, 111]
    B = 3


    Example Output
    Output 1:

            [3, 4]
    Output 2:

            [-1, -1]


    Example Explanation
    Explanation 1:

    The first occurrence of 8 in A is at index 3.
    The last occurrence of 8 in A is at index 4.
    ans = [3, 4]
    Explanation 2:

    There is no occurrence of 3 in the array.*/
    public int[] searchRange(final int[] A, int B) {

        int start = 0, end = A.length-1;
        int mid =0;
        int[] output = new int[2];
        output[0]= -1;
        output[1] = -1;
        while (start <= end) {
            mid = start + (end -start)/2;
            if(A[mid] == B && (mid==0 || A[mid-1] < A[mid])) {
                output[0] = mid;
            }
            if(A[mid] == B && (mid==A.length-1 || A[mid] > A[mid+1])) {
                output[1] = mid;
            }
            if((mid==0 || A[mid-1] < A[mid])) start = mid+1;
            else end = mid-1;
        }
        return output;
    }
}
