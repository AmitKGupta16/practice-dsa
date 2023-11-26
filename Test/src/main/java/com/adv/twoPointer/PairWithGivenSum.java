package com.adv.twoPointer;

public class PairWithGivenSum {
    public static int solve(int[] A, int B) {
        int N = A.length;
        int s=0, e=N-1,cnt=0;
        while(s<e) {
            int sum = A[s] + A[e];
            if(sum==B) {
                cnt++;
                e--;
            }else {
                s++;
            }
        }
        return cnt%(1000000007);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2,6,6,7,9,9},13));
    }
}
