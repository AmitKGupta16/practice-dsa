package com.intermediate.array.assignment;

import java.util.ArrayList;
import java.util.List;
/*Problem Description
        Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.


        Problem Constraints
        1 <= N <= 10^5
        -10^9 <= A[i] <= 10^9


        Input Format
        First argument A is an integer array.


        Output Format
        Return the sum of maximum and minimum element of the array


        Example Input
        Input 1:

        A = [-2, 1, -4, 5, 3]
        Input 2:

        A = [1, 3, 4, 1]


        Example Output
        Output 1:

        1
        Output 2:

        5


        Example Explanation
        Explanation 1:

        Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1.
        Explanation 2:

        Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.*/

public class MaxMinOfAnArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(-2, 1, -4, 5, 3));
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<Integer> A) {
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++) {
            if(A.get(i) > max) {
                max = A.get(i);
            }
            if(A.get(i) <= min) {
                min = A.get(i);
            }
        }
        return max+min;
    }
}
