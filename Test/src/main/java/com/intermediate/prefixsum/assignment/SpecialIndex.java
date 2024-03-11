package com.intermediate.prefixsum.assignment;

/*Problem Description
        Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



        Problem Constraints
        1 <= N <= 105
        -105 <= A[i] <= 105
        Sum of all elements of A <= 109


        Input Format
        First argument contains an array A of integers of size N


        Output Format
        Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



        Example Input
        Input 1:
        A = [2, 1, 6, 4]
        Input 2:

        A = [1, 1, 1]


        Example Output
        Output 1:
        1
        Output 2:

        3


        Example Explanation
        Explanation 1:
        Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
        Therefore, the required output is 1.
        Explanation 2:

        Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
        Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
        Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
        Therefore, the required output is 3.*/
public class SpecialIndex {

    public static void main(String[] args) {
        SpecialIndex specialIndex = new SpecialIndex();
        int cnt = specialIndex.solve(new int[] {2, 1, 6, 4});
        System.out.println(cnt);
    }
    public int solve(int[] A) {
        int N = A.length;
        long[] pfEven = pfEven(A);
        long[] pfOdd = pfOdd(A);
        long se=0,so=0;
        int cnt=0;
        for (int idx=0;idx<N;idx++) {
            se = pfOdd[N-1] - pfOdd[idx];
            so = pfEven[N-1] -pfEven[idx];
            if(idx != 0) {
                se = se + pfEven[idx-1];
                so = so+ pfOdd[idx-1];
            }
            if(se==so) cnt++;

        }
        return cnt;

    }

    private long[] pfEven(int[] A) {
        long[] pfEven = new long[A.length];
        pfEven[0] = A[0];
        for (int idx = 1; idx < A.length; idx++) {
            if (idx % 2 == 0) {
                pfEven[idx] = pfEven[idx - 1] + A[idx];
            } else {
                pfEven[idx] = pfEven[idx - 1];
            }

        }
        return pfEven;
    }

    private long[] pfOdd(int[] A) {
        long[] pfOdd = new long[A.length];
        pfOdd[0] = 0;
        for (int idx = 1; idx < A.length; idx++) {
            if (idx % 2 == 0) {
                pfOdd[idx] = pfOdd[idx - 1];
            } else {
                pfOdd[idx] = pfOdd[idx - 1] + A[idx];
            }

        }
        return pfOdd;
    }
}
