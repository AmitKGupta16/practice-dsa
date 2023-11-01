package com.adv.maths;

public class SmallestPrimeFactorization {
    public static void rangePrimeFactor(int N) {
        int[] spf = new int[N+1];
        for(int i=2;i<=N;i++) {
            spf[i] =i;
        }
        for(int i=2;i*i<=N;i++) {
            if(spf[i]==i) {
                for(int j=i*i; j<=N;j=j+i) {
                    if(spf[j]==j) {
                        spf[j] = i;
                    }
                }
            }
        }
        for(int i=0;i<=N;i++) {
            System.out.print(spf[i] + " ");
        }
    }

    public static void main(String[] args) {
        rangePrimeFactor(10);
    }
}
