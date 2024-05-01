package com.adv.dp.dp2.assignment;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids.
Return the total number unique paths from (1, 1) to (n, m).

Note:
        1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
        2. Given Source Point and Destination points are 1-based index.


Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1


Input Format
Firts and only argument A is a 2D array of size n * m.


        Output Format
Return an integer denoting the number of unique paths from (1, 1) to (n, m).


Example Input
Input 1:

A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
        ]
Input 2:

A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
        ]


Example Output
Output 1:

        2
Output 2:

        0


Example Explanation
Explanation 1:

Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
So, the total number of unique paths is 2.
Explanation 2:

It is not possible to reach (n, m) from (1, 1). So, ans is 0.*/
public class UniquePathsInAGrid {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(List.of(new ArrayList<>(List.of(1,0))));
        UniquePathsInAGrid uniquePathsInAGrid = new UniquePathsInAGrid();
        uniquePathsInAGrid.uniquePathsWithObstacles(list);
    }
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        return uniquePaths(A, A.size()-1,A.get(0).size()-1);
    }

   // start =1, end =2
    public int uniquePaths(ArrayList<ArrayList<Integer>> A, int start, int end) {
        if(start < 0 || end < 0 ) return 0;
        if(start ==0 && end ==0 && A.get(start).get(end) != 1) return 1;

        if(A.get(start).get(end) ==1) return 0;


        return uniquePaths(A,start, end-1) + uniquePaths(A,start-1, end);
    }

    public int uniquePathsTopDown(ArrayList<ArrayList<Integer>> A, int start, int end) {
        if(start > A.size()-1 || end > A.get(0).size()-1 ) return 0;
        if(start ==0 && end ==0 && A.get(start).get(end) != 1) return 1;

        if(A.get(start).get(end) ==1) return 0;


        return uniquePaths(A,start, end+1) + uniquePaths(A,start+1, end);

    }
}
