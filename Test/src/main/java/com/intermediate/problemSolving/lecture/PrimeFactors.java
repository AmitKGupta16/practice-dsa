package com.intermediate.problemSolving.lecture;
/*
Prime no. which have two factor 1 and number itself
*/

public class PrimeFactors {
    public static void main(String[] args) {
        PrimeFactors primeFactors = new PrimeFactors();
        System.out.println(primeFactors.checkPrime(4));

    }
    public boolean checkPrime(int N) {
        if(factor(N)==2) return true;
        else return false;
    }

    public int factor(int N) {
        int cnt=0;
        for(int i=1;i*i<=N;i++) {
            if(N%i==0) {
                if(i==N/i) cnt++;
                else cnt=cnt+2;
            }
        }
        return cnt;
    }
}
