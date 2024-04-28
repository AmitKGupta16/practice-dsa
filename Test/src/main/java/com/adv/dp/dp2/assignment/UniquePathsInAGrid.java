package com.adv.dp.dp2.assignment;

import java.util.ArrayList;

public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        int[][] dp = new int[row][col];
        dp[0][0]=1;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(A.get(i).get(j)==1) dp[i][j]=0;
                if(i==0 || j==0) dp[i][j]=1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[0][0];
    }
}
