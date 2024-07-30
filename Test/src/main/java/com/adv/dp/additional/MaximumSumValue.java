package com.adv.dp.additional;

public class MaximumSumValue {
    public static void main(String[] args) {
        int[] A = {-21, 34, 3, 46, 8, -47, -47};

        System.out.println(solve(A, -13, 10, 9));
    }

    public static int solve(int[] A, int B, int C, int D) {
        int[] val = new int[A.length];
        val[0] = B * A[0];
        for (int i = 1; i < A.length; i++) {
            int mul = B * A[i];
            if (mul > val[i - 1]) val[i] = mul;
            else val[i] = val[i - 1];
        }

        val[0] += C * A[0];
        for (int i = 1; i < A.length; i++) {
            int mul = val[i] + (C * A[i]);
            if (mul > val[i - 1]) val[i] = mul;
            else val[i] = val[i - 1];
        }

        val[0] += D * A[0];
        for (int i = 1; i < A.length; i++) {
            int mul = val[i] + (D * A[i]);
            if (mul > val[i - 1]) val[i] = mul;
            else val[i] = val[i - 1];
        }

        return val[A.length - 1];
    }
/*    public static int solve(int[] A, int B, int C, int D) {
        int i;
        int N = A.length;
        int firstSum = Integer.MIN_VALUE;
        int firstIndex = 0;
        for (i = 0; i < N; i++) {
            int sum = A[i] *B;
            if(sum > firstSum) {
                firstSum = sum;
                firstIndex =i;
            }
        }

        int secondSum = Integer.MIN_VALUE;
        int secondIndex = 0;
        for (i = firstIndex; i < N; i++) {
            int sum = A[i] *C;
            if(sum > secondSum) {
                secondSum = sum;
                secondIndex =i;
            }
        }

        int thirdSum = Integer.MIN_VALUE;
        for (i = secondIndex; i < N; i++) {
            int sum = A[i] *D;
            if(sum > thirdSum) {
                thirdSum = sum;
            }
        }


        return firstSum + secondSum +thirdSum;
    }*/
}
