package com.adv.dp.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Problem Description
        Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
        However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.

        Return the maximum possible sum.

        Note: You are allowed to choose more than 2 numbers from the grid.


        Problem Constraints
        1 <= N <= 20000
        1 <= A[i] <= 2000


        Input Format
        The first and the only argument of input contains a 2d matrix, A.


        Output Format
        Return an integer, representing the maximum possible sum.


        Example Input
        Input 1:

        A = [
        [1]
        [2]
        ]
        Input 2:

        A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
        ]


        Example Output
        Output 1:

        2
        Output 2:

        8


        Example Explanation
        Explanation 1:

        We will choose 2 (From 2nd row 1st column).
        Explanation 2:

        We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).*/
public class MaxSumWithoutAdjacentElement {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(List.of(new ArrayList<>(List.of(1, 2, 3, 4)),
                new ArrayList<>(List.of(2, 3, 4, 5))));
        adjacent(A);

    }
    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        int size= A.get(0).size();
        int[] dp = new int[size];
        Arrays.fill(dp,-1);
        //System.out.println(maxSum1(A,0,size-1));
        System.out.println(maxSum1WithDp(A,0,size-1,dp));
        return 0;
    }

    public static int maxSumWithDP(ArrayList<ArrayList<Integer>> A,int start, int end,int[] dp) {
        if(start > end) return 0;
        ArrayList<Integer> row1 = A.get(0);
        ArrayList<Integer> row2 = A.get(1);
        if(start==end) {
            if(dp[start] ==-1) {
                dp[start] = Math.max(row1.get(start), row2.get(start));
                return dp[start];
            }
        }
        if(start+2 <=end && dp[start+2] ==-1) {
            dp[start+2] =maxSumWithDP(A,start+2,end,dp);
        }
        if(start+1 <=end &&  dp[start+1] ==-1) {
            dp[start+1] =maxSumWithDP(A,start+1,end,dp);
        }
        int currentMax = Math.max(row1.get(start),row2.get(start)) + (start+2<=end ? dp[start+2] :0);
        dp[start]= Math.max(currentMax,(start+1 <=end ?dp[start+1]:0));
        return dp[start];
    }

    public static int  maxSum(ArrayList<ArrayList<Integer>> A,int start, int end) {
        if(start > end) {
            return 0;
        }
        ArrayList<Integer> row1 = A.get(0);
        ArrayList<Integer> row2 = A.get(1);
        if(start == end) {
            return Math.max(row1.get(start),row2.get(start));
        }
        int currentMax = Math.max(row1.get(start),row2.get(start)) + maxSum(A,start+2, end);
        return Math.max(currentMax, maxSum(A,start+1, end));
    }

    public static int  maxSum1(ArrayList<ArrayList<Integer>> A,int start,int end) {
        if(start > end) return 0;
        ArrayList<Integer> row1 = A.get(0);
        ArrayList<Integer> row2 = A.get(1);
        if(start==end) {
            return Math.max(row1.get(start), row2.get(start));
        }
        int currentMax = Math.max(row1.get(start), row2.get(start)) + maxSum(A,start+2,end);
        return Math.max(currentMax,maxSum1(A,start+1,end));
    }

    public static int  maxSum1WithDp(ArrayList<ArrayList<Integer>> A,int start,int end,int[] dp) {
        if(start > end) return 0;
        ArrayList<Integer> row1 = A.get(0);
        ArrayList<Integer> row2 = A.get(1);
        if(start==end) {
            if(dp[start]==-1) {
                dp[start] = Math.max(row1.get(start), row2.get(start));
                return dp[start];
            }
        }
        if(start+2<=end && dp[start+2] ==-1) {
            dp[start+2] = maxSum(A,start+2,end);
        }
        if(start+1<=end && dp[start+1]==-1) {
            dp[start+1] = maxSum(A,start+1,end);
        }
        int currentMax = Math.max(row1.get(start), row2.get(start)) + (start+2<=end? dp[start+2]:0);
        dp[start]= Math.max(currentMax,(start+1<=end? dp[start+1]:0));
        return dp[start];
    }
}
