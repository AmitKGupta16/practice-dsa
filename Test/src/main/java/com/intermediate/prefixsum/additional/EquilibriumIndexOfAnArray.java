package com.intermediate.prefixsum.additional;

import java.util.ArrayList;
import java.util.List;
/*Problem Description
        You are given an array A of integers of size N.

        Your task is to find the equilibrium index of the given array

        The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

        If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

        Note:

        Array indexing starts from 0.
        If there is no equilibrium index then return -1.
        If there are more than one equilibrium indexes then return the minimum index.


        Problem Constraints
        1 <= N <= 10^5
        -10^5 <= A[i] <= 10^5


        Input Format
        First arugment is an array A .


        Output Format
        Return the equilibrium index of the given array. If no such index is found then return -1.


        Example Input
        Input 1:
        A = [-7, 1, 5, 2, -4, 3, 0]
        Input 2:

        A = [1, 2, 3]


        Example Output
        Output 1:
        3
        Output 2:

        -1


        Example Explanation
        Explanation 1:
        i   Sum of elements at lower indexes    Sum of elements at higher indexes
        0                   0                                   7
        1                  -7                                   6
        2                  -6                                   1
        3                  -1                                  -1
        4                   1                                   3
        5                  -3                                   0
        6                   0                                   0

        3 is an equilibrium index, because:
        A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
        Explanation 1:

        i   Sum of elements at lower indexes    Sum of elements at higher indexes
        0                   0                                   5
        1                   1                                   3
        2                   3                                   0
        Thus, there is no such index.*/

public class EquilibriumIndexOfAnArray {
    public static void main(String[] args) {
        EquilibriumIndexOfAnArray equilibriumIndexOfAnArray = new EquilibriumIndexOfAnArray();
        int ans=   equilibriumIndexOfAnArray.solve(new ArrayList<>(List.of(-7, 1, 5, 2, -4, 3, 0)));
        //int ans=   equilibriumIndexOfAnArray.solve(new ArrayList<>(List.of(1, 2, 3)));
        System.out.println(ans);


    }
    private int[] pfLowerIndex(ArrayList<Integer> A) {
        int [] pfLower = new int[A.size()];
        pfLower[0] = A.get(0);
        for(int idx = 1; idx < A.size(); idx++) {
            pfLower[idx] = pfLower[idx-1] + A.get(idx);
        }
        return pfLower;
    }

    private int[] pfHigherIndex(ArrayList<Integer> A) {
        int[] pfHigher = new int[A.size()];
        pfHigher[A.size()-1] = A.get(A.size()-1);
        for( int idx = A.size()-2; idx >=0; idx--) {
            pfHigher[idx] = pfHigher[idx+1] + A.get(idx);
        }
        return pfHigher;
    }
    public int solve(ArrayList<Integer> A) {
        if(A.size() <=1 ) return 0;
        int[] pfLower = pfLowerIndex(A);
        int[] pfHigher = pfHigherIndex(A);
        int start = 0 , end = A.size()-1;
        int cnt =0 ;
        //int ans =0;
        while(start < end) {
           if( pfLower[start] == pfHigher[end] ) {
               cnt++;
               //ans = start;
           }
           start ++; end --;

        }
        return cnt == 0 ? -1:start;
    }
}
