package com.adv.dp.assignment;

import java.util.Arrays;
/*Problem Description
        You are climbing a staircase and it takes A steps to reach the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Return the number of distinct ways modulo 1000000007



        Problem Constraints
        1 <= A <= 10^5



        Input Format
        The first and the only argument contains an integer A, the number of steps.



        Output Format
        Return an integer, representing the number of ways to reach the top.



        Example Input
        Input 1:

        A = 2
        Input 2:

        A = 3


        Example Output
        Output 1:

        2
        Output 2:

        3


        Example Explanation
        Explanation 1:

        Distinct ways to reach top: [1, 1], [2].
        Explanation 2:

        Distinct ways to reach top: [1 1 1], [1 2], [2 1].*/

public class Stairs {
    public  static  int[] dp;

    public static void main(String[] args) {
        int N= 3;
        dp = new int[N+1];
        Arrays.fill(dp,-1);
        System.out.println(stair(N));
    }

    public static int stair(int N) {
        if(N<=1) {
            return 1;
        }
        if(dp[N] !=-1) {
            return dp[N];
        }
        dp[N] = (stair(N-1) +stair(N-2)) %1000000007;
        return dp[N];
    }

/*    public static int climbStairs(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        return stair(A,dp);
    }*/

/*    public static int stair(int A,int[] dp) {
        if(A==0 || A==1) {
            return 1;
        }
        if(dp[A] !=-1) {
            return dp[A];
        }
        dp[A] = (stair(A-1,dp) + stair(A-2,dp)) %1000000007;
        return dp[A];
    }*/
}
