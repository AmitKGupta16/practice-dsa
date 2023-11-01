package com.adv.maths;

public class PascalTriangle {
    public static int[][] pascalTriangle(int N) {
        int[][] matrix =  new int[N+1][N+1];
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) {
                    matrix[i][j] =1;
                }else {
                    matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix= pascalTriangle(4);
        for(int i=0;i<=4;i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
