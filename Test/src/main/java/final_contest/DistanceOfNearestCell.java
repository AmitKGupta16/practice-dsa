package final_contest;

import java.util.ArrayDeque;
import java.util.Queue;

public class DistanceOfNearestCell {
    public int[][] solve(int[][] A) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[row][col];
        Queue<Pair> queue = new ArrayDeque<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(A[i][j]==1) {
                    queue.add(new Pair(i,j));
                    ans[i][j] =0;
                }else ans[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(int i =0;i<4;i++) {
                int newX = pair.x + dx[i];
                int newY = pair.y +dy[i];
                if(newX >= 0 && newX < row && newY >=0 || newY < col && ans[newY][newX] == Integer.MAX_VALUE ) {
                    ans[newX][newY] = ans[pair.x] [pair.y] +1;
                    queue.add(new Pair(newX,newY));
                }
            }
        }
        return ans;
    }
}

class Pair {
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
