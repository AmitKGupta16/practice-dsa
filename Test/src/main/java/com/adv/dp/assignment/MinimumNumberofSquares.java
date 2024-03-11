package com.adv.dp.assignment;

import java.util.Arrays;

/*Problem Description
        Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.



        Problem Constraints
        1 <= A <= 10^5



        Input Format
        First and only argument is an integer A.



        Output Format
        Return an integer denoting the minimum count.



        Example Input
        Input 1:

        A = 6
        Input 2:

        A = 5


        Example Output
        Output 1:

        3
        Output 2:

        2


        Example Explanation
        Explanation 1:

        Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
        Minimum count of numbers, sum of whose squares is 6 is 3.
        Explanation 2:

        We can represent 5 using only 2 numbers i.e. 1^2 + 2^2 = 5*/
public class MinimumNumberofSquares {
    public static int[] dp;

    public static void main(String[] args) {
        int N=2;
        dp = new int[N+1];
        Arrays.fill(dp,-1);
        dp[0] =0;
        //System.out.println(minSquare(N));
        System.out.println(countMinSquare(N));

    }

    public static int minSquare(int N) {
        if(N==0) {
            return 0;
        }
        if(dp[N] !=-1) {
            return dp[N];
        }
        int minVal = Integer.MAX_VALUE;
        for(int i=1;i*i<=N;i++) {
            minVal = Math.min(minVal,minSquare(N-(i*i)));
        }
        dp[N] = minVal+1;
        return dp[N];
    }

    public static int countMinSquare(int N) {
        for(int i=1;i<=N;i++) {
            int minVal = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++) {
                minVal = Math.min(minVal,dp[i-(j*j)]);
            }
            dp[i] =minVal+1;
        }
        return dp[N];
    }
/*    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1;i<=A;i++) {
            int minVal = Integer.MAX_VALUE;
            for(int x=1;x*x<=i;x++){
                minVal =Math.min(minVal,dp[i-x*x]);
            }
            dp[i] = minVal+1;
        }
        return dp[A];
    }*/


}
