package test;

public class RowWiseSearchMatrix {
    public static void main(String[] args) {
       // int[][] A = {{2, 2}, {2, 2}};
        int[][] A= {{1,2,3},{4,5,6},{7,8,9}};
        int B = 2;
        System.out.println(solve(A, B));
    }

    public static int solve(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int i = 0, j = M - 1;
        int ans = Integer.MAX_VALUE;
        while (i < N && j >= 0) {
            if (A[i][j] >= B) {
                if(A[i][j] == B) {
                    int val = (i + 1) * 1009 + (j + 1);
                    ans = Math.min(ans, val);
                }
                j--;
            } else {
                i++;
            }
        }
        return ans ==Integer.MAX_VALUE?-1:ans;
    }
}
