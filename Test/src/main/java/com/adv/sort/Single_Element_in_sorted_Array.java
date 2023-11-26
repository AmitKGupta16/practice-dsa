package com.adv.sort;

/*Problem Description
        Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
        Elements which are appearing twice are adjacent to each other.

        NOTE: Users are expected to solve this in O(log(N)) time.

        Problem Constraints
        1 <= |A| <= 100000

        1 <= A[i] <= 10^9

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the single element that appears only once.

        Example Input
        Input 1:
        A = [1, 1, 7]
        Input 2:
        A = [2, 3, 3]

        Example Output
        Output 1:
        7
        Output 2:
        2

        Example Explanation
        Explanation 1:
        7 appears once
        Explanation 2:
        2 appears once*/
public class Single_Element_in_sorted_Array {
    public static int solve(int[] A) {
        int N = A.length;
        int s=0,e=N-1;
        while(s<=e) {
            int mid = s+(e-s)/2;
            int twinIndex = -1;
            if((mid==0 || A[mid] !=A[mid-1]) && (mid==N-1 || A[mid] != A[mid+1])) {
                return A[mid];
            }
            if(A[mid] == A[mid-1]) {
                twinIndex = mid-1;
            }else {
                twinIndex = mid;
            }
            if(twinIndex %2 ==0) {
                s = mid+1;
            }else {
                e = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 1, 7}));
    }
}
