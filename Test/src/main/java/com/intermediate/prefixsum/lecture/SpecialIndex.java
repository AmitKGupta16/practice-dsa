package com.intermediate.prefixsum.lecture;

public class SpecialIndex {
    public static void main(String[] args) {
        SpecialIndex specialIndex = new SpecialIndex();
        int cnt = specialIndex.specialIndexCount(new int[] {4,3,2,7,6,-2});
        System.out.println(cnt);
    }

    public int specialIndexCount(int A[]) {
        int N = A.length;
        int[] pfEven = pfEven(A);
        int[] pfOdd = pfOdd(A);
        int se = 0, so = 0, cnt = 0;

        //se = arse(0,i-1) + arso(i+1,N-1), check start index =0
        //se  = (pfe(i-1) - pfe(0-1)) + (pfo(N-1) - pfo(i+1-1))

        //so = arso(0,i-1) + arse(i+1,N-1), check start index =0
        //se  = (pfo(i-1) - pfo(0-1)) + (pfe(N-1) - pfe(i+1-1))

        for(int idx = 0; idx < N ;idx++) {
            se = pfOdd[N-1] - pfOdd[idx];
            so = pfEven[N-1] - pfEven[idx];
            if(idx !=0) {
                se = se + pfEven[idx-1];
                so = so + pfOdd[idx-1];
            }
            if(se == so) cnt++;
        }
        return cnt;
    }
    public int[] pfEven(int[] A) {
        int N = A.length;
        int[] pfEven = new int[N];
        pfEven[0] = A[0];
        for(int idx = 1; idx < N; idx++) {
            if(idx % 2 == 0) {
                pfEven[idx] = pfEven[idx-1] + A[idx];
            }else {
                pfEven[idx] = pfEven[idx-1];
            }
        }
        return pfEven;
    }

    public int[] pfOdd(int[] A) {
        int N = A.length;
        int[] pfOdd = new int[N];
        pfOdd[0] =0;
        for(int idx =1; idx < N; idx++) {
            if(idx % 2 == 0) {
                pfOdd[idx] = pfOdd[idx-1];
            }else {
                pfOdd[idx] = pfOdd[idx-1] + A[idx];
            }
        }
        return pfOdd;
    }
}
