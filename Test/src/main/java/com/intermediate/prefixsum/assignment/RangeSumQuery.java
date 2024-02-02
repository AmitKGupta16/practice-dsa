package com.intermediate.prefixsum.assignment;


import java.util.ArrayList;
import java.util.List;

/*Problem Description
        You are given an integer array A of length N.
        You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
        For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
        More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.



        Problem Constraints
        1 <= N, M <= 10^5
        1 <= A[i] <= 10^9
        0 <= L <= R < N


Input Format
        The first argument is the integer array A.
        The second argument is the 2D integer array B.


        Output Format
        Return an integer array of length M where ith element is the answer for ith query in B.


        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = [[0, 3], [1, 2]]
        Input 2:

        A = [2, 2, 2]
        B = [[0, 0], [1, 2]]


        Example Output
        Output 1:
        [10, 5]
        Output 2:

        [2, 4]


        Example Explanation
        Explanation 1:
        The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
        The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
        Explanation 2:

        The sum of all elements of A[0 ... 0] = 2 = 2.
        The sum of all elements of A[1 ... 2] = 2 + 2 = 4.*/

public class RangeSumQuery {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(0, 3)));
        B.add(new ArrayList<>(List.of(1, 2)));
        ArrayList<Integer> A1 = new ArrayList<>(List.of(2, 2, 2));
        ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
        B1.add(new ArrayList<>(List.of(0, 0)));
        B1.add(new ArrayList<>(List.of(1, 2)));

        System.out.println(rangeSum(A,B));
        System.out.println(rangeSum(A1,B1));


    }
    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        long[] preFixSum = new long[A.size()];
        preFixSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            preFixSum[i] = preFixSum[i - 1] + A.get(i);
        }
        ArrayList<Long> result = new ArrayList<>();
        for (ArrayList<Integer> range : B) {
            int s = range.get(0);
            int e = range.get(1);
            long sum = 0;
            if (s == 0)
                sum = preFixSum[e];
            else
                sum = preFixSum[e] - preFixSum[s - 1];

            result.add(sum);
        }
        return result;
    }
}
