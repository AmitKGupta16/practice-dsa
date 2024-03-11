package test;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = {1,3}, B = {2};
        int j=0,k=0;
        int end = A.length+B.length+1;
        int mid = end/2;
        int[] res = new int[A.length+B.length];
        int s=0;
        for(int i=0;i<Math.min(A.length,A.length);i++) {
            if(k < B.length && j< A.length &&(A[j] < B[k])) {
                //res[s] = A[j];
                //s++;
                if(mid==0) break;
                mid--;
                j++;
            } else if(k < B.length &&  j< A.length && (B[k] < A[j])) {
               // res[s] = B[k];
                //s++;
                if(mid==0) break;
                mid--;
                k++;
            }
        }
        while(j<A.length) {
           // s++;
          //  res[s] = A[j];
            if(mid==0) break;
            j++;
            mid--;
           // s++;
        }
        while(k<B.length) {
            //s++;
            //res[s] = B[k];
            if(mid==0) break;
            k++;
            mid--;
            //s++;
        }
        //Arrays.stream(res).forEach(System.out::print);
    }
}
