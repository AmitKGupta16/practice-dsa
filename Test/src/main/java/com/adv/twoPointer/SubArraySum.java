package com.adv.twoPointer;

import java.util.ArrayList;
/*Q1. Subarray with given sum
//        Problem Description
//        Given an array of positive integers A and an integer B,
//        find and return first continuous subarray which adds to B.
//        If the answer does not exist return an array with a single integer "-1".
//        First sub-array means the sub-array for which starting index in minimum.

        Problem Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 109
        1 <= B <= 109

        Input Format
        The first argument given is the integer array A.
        The second argument given is integer B.
        Output Format
        Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = 5
        Input 2:
        A = [5, 10, 20, 100, 105]
        B = 110

        Example Output
        Output 1:
        [2, 3]
        Output 2:
        [-1]

        Example Explanation
        Explanation 1:
        [2, 3] sums up to 5.
        Explanation 2:
        No subarray sums up to required number.*/
public class SubArraySum {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int N= A.size();
        int i=0,j=0,sum= A.get(0);
        while(j<N) {
            if(sum==B) {
                for(int k=i;k<=j;k++) {
                    res.add(A.get(k));
                }
                return res;
            } else if(sum<B) {
                j++;
                if(j==N) {
                    break;
                }
                sum+=A.get(j);
            } else {
                sum-=A.get(i);
                i++;
                if(i>N && i<=N-1) {
                    j++;
                    sum+=A.get(j);
                }
            }
        }
        res.add(-1);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);data.add(2);data.add(3);data.add(4);
        data.add(5);
        System.out.println(solve(data,5));
    }
}
