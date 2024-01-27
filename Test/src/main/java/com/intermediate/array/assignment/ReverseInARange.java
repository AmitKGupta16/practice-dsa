package com.intermediate.array.assignment;

import java.util.ArrayList;
import java.util.List;
/*Problem Description
        Given an array A of N integers and also given two integers B and C. Reverse the elements of the array A within the given inclusive range [B, C].


        Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^9
        0 <= B <= C <= N - 1


        Input Format
        The first argument A is an array of integer.
        The second and third arguments are integers B and C


        Output Format
        Return the array A after reversing in the given range.


        Example Input
        Input 1:

        A = [1, 2, 3, 4]
        B = 2
        C = 3
        Input 2:

        A = [2, 5, 6]
        B = 0
        C = 2


        Example Output
        Output 1:

        [1, 2, 4, 3]
        Output 2:

        [6, 5, 2]


        Example Explanation
        Explanation 1:

        We reverse the subarray [3, 4].
        Explanation 2:

        We reverse the entire array [2, 5, 6].*/

public class ReverseInARange {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4));
        int B=2;
        int C=3;
        System.out.println(solve(A,B,C));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
        reverseRange(A,B,C);
        return A;
    }
    public static void reverseRange(ArrayList<Integer> A, int B, int C) {
        int i=B,j=C;
        int temp =0;
        while(i < j) {
            temp= A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);
            i++;j--;
        }
    }
}
