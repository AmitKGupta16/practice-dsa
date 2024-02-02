package com.adv.graph.graph1.assignment;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
        Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.

        Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



        Problem Constraints
        1 <= N, M <= 1000

        A[i][j] = 'X' or 'O'



        Input Format
        The First and only argument is character matrix A.



        Output Format
        Return a single integer denoting number of black shapes.



        Example Input
        Input 1:

        A = [ [X, X, X], [X, X, X], [X, X, X] ]
        Input 2:

        A = [ [X, O], [O, X] ]


        Example Output
        Output 1:

        1
        Output 2:

        2


        Example Explanation
        Explanation 1:

        All X's belong to single shapes
        Explanation 2:

        Both X's belong to different shapes*/

public class BlackShapes {
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of("XXX", "XXX", "XXX"));
        System.out.print(black(A));

    }

    public static int black(ArrayList<String> A) {
        int N = A.size();
        String B = A.get(0);
        int M = B.length();
        char[][] mat = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = A.get(i).charAt(j);
            }
        }
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == 'X' && !visited[i][j]) {
                    shapesX(mat,visited , i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void shapesX(char[][] mat, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 'O' || visited[i][j] == true) {
            return;
        }
        visited[i][j]=true;
        shapesX(mat, visited, i, j - 1); //left
        shapesX(mat, visited, i - 1, j); // top
        shapesX(mat, visited, i, j + 1); //right
        shapesX(mat, visited, i + 1, j); //bottom
    }
}
