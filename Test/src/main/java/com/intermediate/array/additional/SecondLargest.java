package com.intermediate.array.additional;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
        You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


        Problem Constraints
        1 <= |A| <= 10^5

        0 <= A[i] <= 10^9



        Input Format
        The first argument is an integer array A.



        Output Format
        Return the second largest element. If no such element exist then return -1.



        Example Input
        Input 1:

        A = [2, 1, 2]
        Input 2:

        A = [2]


        Example Output
        Output 1:

        1
        Output 2:

        -1


        Example Explanation
        Explanation 1:

        First largest element = 2
        Second largest element = 1
        Explanation 2:

        There is no second largest element in the array.*/
public class SecondLargest {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1,2,3,4));
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<Integer> A) {
        int firstMax=Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++) {
            if(A.get(i) > firstMax) {
                secondMax = firstMax;
                firstMax = A.get(i);
            } else if(A.get(i) > secondMax && A.get(i)!= firstMax) {
                secondMax=A.get(i);
            }
        }
        if(secondMax == Integer.MIN_VALUE) {
            return -1;
        }

        return secondMax;
    }
}
