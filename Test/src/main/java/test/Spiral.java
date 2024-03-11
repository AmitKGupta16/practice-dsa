package test;

import java.util.Arrays;

public class Spiral {
    public static void main(String[] args) {
        int N = 4;
        int[][] A = new int[N][N];
        int i = 0, j = 0;
        int ele = 1;
        while (N > 1) {
            for (int cnt = 1; cnt < N; cnt++) { //--123

                A[i][j] = ele++;
                j++;
            }
            for (int cnt = 1; cnt < N; cnt++) { //--456

                A[i][j] = ele++;
                i++;
            }
            for (int cnt = 1; cnt < N; cnt++) { //--789

                A[i][j] = ele++;
                j--;
            }
            for (int cnt = 1; cnt < N; cnt++) { //--10 11 12
                A[i][j] = ele++;
                i--;
            }
            i++;
            j++;
            N = N - 2;
        }
        if(N==1) {
            //print A[i][j];
        }
        Arrays.stream(A).forEach(val -> System.out.println(Arrays.toString(val)));
    }

}
