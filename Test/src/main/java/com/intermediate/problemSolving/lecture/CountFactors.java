package com.intermediate.problemSolving.lecture;

public class CountFactors {
    public static void main(String[] args) {
        CountFactors countFactors = new CountFactors();
        System.out.println(countFactors.factors(10));
        System.out.println(countFactors.optimizeFactors(10));
    }
    public int factors(int A){
        int cnt=0;
        for(int i=1;i<=A;i++) {
            if(A%i==0) {
                cnt++;
            }
        }
        return cnt;
    }
    //Optimze code
    public int optimizeFactors(int A) {
        int cnt=0;
        for(int i=1;i*i<=A;i++) {
            if(A%i==0) {
                if(i==A/i) cnt++;
                else cnt=cnt+2;
            }
        }
        return cnt;
    }
}
