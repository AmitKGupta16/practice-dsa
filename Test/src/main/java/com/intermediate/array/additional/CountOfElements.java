package com.intermediate.array.additional;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
        Given an array A of N integers.
        Count the number of elements that have at least 1 elements greater than itself.


        Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^9


        Input Format
        First and only argument is an array of integers A.


        Output Format
        Return the count of elements.


        Example Input
        Input 1:
        A = [3, 1, 2]
        Input 2:
        A = [5, 5, 3]


        Example Output
        Output 1:
        2
        Output 2:
        1


        Example Explanation
        Explanation 1:
        The elements that have at least 1 element greater than itself are 1 and 2
        Explanation 2:
        The elements that have at least 1 element greater than itself is 3*/

public class CountOfElements {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 1, 2));
        ArrayList<Integer> A1 = new ArrayList<>(List.of(5, 5, 3));
        System.out.println(solve(A));
        System.out.println(solve(A1));
    }

/* Question:   Given an array A of N integers.
    Count the number of elements that have at least 1 elements greater than itself.*/

/* Hint-1    Which elements do not have at least 1 elements greater than itself?
    Only elements that are equal to the maximum value of the array do not
    satisfy this.
    Try to solve the problem in O(N) time complexity.*/

/* Hint-2   We need to count the number of elements in the array
    that are not equal to the maximum value of the array.
    We can traverse the array and get this count.

    Time Complexity : O(N)
    Space Complexity : O(1)*/

    public static int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if(max < A.get(i)) max = A.get(i);

        }
        int cnt=0;
        for (int i = 0; i < A.size(); i++) {
            if(max > A.get(i)) cnt++;

        }
        return cnt;
    }
}
