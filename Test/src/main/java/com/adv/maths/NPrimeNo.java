package com.adv.maths;

import java.util.ArrayList;

public class NPrimeNo {

    public static ArrayList<Integer> solve(int N) {
        boolean[] isPrime = new boolean[N+1];
        for(int i=2;i<=N;i++) {
            isPrime[i] = true;
        }
        for(int i=2;i*i<=N ;i++) {
            if(isPrime[i]==true) {
                for(int j=i*i ;j<=N;j+=i){
                    isPrime[j]= false;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<=N;i++) {
            if(isPrime[i]==true) {
                res.add(i);
            }

        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(solve(20));

    }
}
