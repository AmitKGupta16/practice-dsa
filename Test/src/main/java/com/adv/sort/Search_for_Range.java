package com.adv.sort;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
        Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

        Return an array of size 2, such that
        First element = Left most index of B in A
        Second element = Right most index of B in A.
        If B is not found in A, return [-1, -1].

        Note : Your algorithm's runtime complexity must be in the order of O(log n).

        Problem Constraints
        1 <= N <= 106
        1 <= A[i], B <= 109

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

public class Search_for_Range {
    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int N= A.size();
        int s=0, e= N-1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(N==1) {
            res.add(0);
            res.add(0);
            return res;
        }
        while(s <= e) {
            int  mid = s+(e-s)/2;
            if((A.get(mid)== B && (mid==0 || A.get(mid) > A.get(mid-1))) ) {
                res.add(mid);
            }
            if(B <= A.get(mid)) {
                e = mid-1;

            } else {
                s= mid+1;
            }
        }
        s=0;e=N-1;
        while(s <= e) {
            int  mid = s+(e-s)/2;
            if((A.get(mid)== B && (mid==N-1 || A.get(mid) < A.get(mid+1))) ) {
                res.add(mid);
            }
            if(B >= A.get(mid)) {
                s = mid+1;

            } else {
                e= mid-1;
            }
        }
        if(res.isEmpty()) {
            res.add(-1);
            res.add(-1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);list.add(10);list.add(10);list.add(10);list.add(11);list.add(12);
        System.out.println(searchRange(list,10));
    }
}
