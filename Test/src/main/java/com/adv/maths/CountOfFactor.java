package com.adv.maths;

import java.util.ArrayList;

public class CountOfFactor {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        int[] cntf = new int[N+1];
        cntf[0]=0;
        cntf[1]=1;
        for(int i=2;i<=N;i++) {
            cntf[i]=2;
        }
        for(int i=2;i<=N/2;i++) {
            for(int j=2*i;j<=N;j=j+i) {
                cntf[j] += 1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<=N;i++) {
            res.add(cntf[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);A.add(3);A.add(4);A.add(5);A.add(6);A.add(7);A.add(8);A.add(9);A.add(10);
        System.out.println(solve(A));



        //solve()

    }
}
