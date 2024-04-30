package com.adv.dp.dp3.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



 Problem Constraints
1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format
First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format
Return the maximum value that fills the knapsack completely



Example Input
Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output
Output 1:

        5
Output 2:

        14


Example Explanation
Explanation 1:

Only valid possibility is to take the given item.
        Explanation 2:

Take the second item twice.*/
public class UnboundedKnapsack {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        dp[0] =0;
        return calculate(A,B,C,dp);
    }

    public int calculate(int A, ArrayList<Integer> B, ArrayList<Integer> C, int[] dp) {
        for (int i = 0; i <= A; i++) {
            for(int j = 0; j < B.size(); j++) {
                if(i >= C.get(j)) {
                    dp[i] = Math.max(dp[i], B.get(j) + dp[i-C.get(j)]);
                }
            }
        }
        return dp[A];
    }
}
