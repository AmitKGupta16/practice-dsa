package com.adv.binarySearch;

import java.util.ArrayList;

public class MatrixSearch {
    public static int searchInMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();
        int start=0,end = N*M -1;
        if(B < A.get(0).get(0) || B > A.get(N-1).get(M-1)) return 0;
        while(start <= end) {
            int mid = start + (end-start)/2;
            int row = mid/M;
            int col = mid%M;
            int current = A.get(row).get(col);
            if(current ==B) return 1;
            else if(B > current) start =mid+1;
            else end = mid-1;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
