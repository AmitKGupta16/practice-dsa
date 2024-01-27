package com.intermediate.array.lecture;
/* Given an Array of size N, Rotate the array from right to left Kth time
arr = {1 2 3 4 5} K =3
k =1 { 5 1 2 3 4}
k= 2 { 4 5 1 2 3}
K= 3 { 3 4 5 1 2} */

/* If K greater than N reverse process will repeat.So, will add K = K % N
arr = {1 2 3 4 5} K =6
k =1 { 5 1 2 3 4}
k= 2 { 4 5 1 2 3}
K= 3 { 3 4 5 1 2}
K= 4 { 2 3 4 5 1}
K= 5 { 1 2 3 4 5} - After 5th reverse get same array
k =6 { 5 1 2 3 4} - After 6th reverse get K=1 reverse array


 */
public class RotateArrayKthTime {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = {1,2,3,4,5};
        int K=3;
        solve(A,3);
        for (int val : A) System.out.print(val + " ");
        solve(B,3);
        for (int val : A) System.out.print(val + "-");

    }
    //brute force approach
    public static void solve(int[] A,int K){
        int N = A.length;
        for(int time=1;time<=K;time++) {
            int temp = A[N-1];
            for(int i=N-1;i>0;i--) {
                A[i] = A[i-1];
            }
            A[0]= temp;
        }
    }

    //optimized approach
    // K=K % N, we are doing for avoid repeatation , if K is greater than N then revers
    // process will be repeat
    public static void solve1(int[] A,int K){
        int N = A.length;
        K= K % N;
        reverse(A,0,N-1);
        reverse(A,0,K-1);
        reverse(A,K,N-1);

    }
    public static void reverse(int[] A, int l, int r) {
        int i=l,j=r;
        int temp=0;
        while(i<j) {
            temp =A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
