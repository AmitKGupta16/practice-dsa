package com.adv.dp.assignment;

import java.util.Arrays;

public class Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5507));
    }

    public static int climbStairs(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        return stair(A,dp);
    }

    public static int stair(int A,int[] dp) {
        if(A==0 || A==1) {
            return 1;
        }
        if(dp[A] !=-1) {
            return dp[A];
        }
        dp[A] = (stair(A-1,dp) + stair(A-2,dp)) %1000000007;
        return dp[A];
    }
}
