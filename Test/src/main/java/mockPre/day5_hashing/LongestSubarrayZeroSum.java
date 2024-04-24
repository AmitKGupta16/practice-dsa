package mockPre.day5_hashing;

//Problem Description
//        Given an array A of N integers.
//        Find the length of the longest subarray in the array which sums to zero.
//
//        If there is no subarray which sums to zero then return 0.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -10^9 <= A[i] <= 10^9
//
//
//        Input Format
//        Single argument which is an integer array A.
//
//
//        Output Format
//        Return an integer.
//
//
//        Example Input
//        Input 1:
//
//        A = [1, -2, 1, 2]
//        Input 2:
//
//        A = [3, 2, -1]
//
//
//        Example Output
//        Output 1:
//
//        3
//        Output 2:
//
//        0
//
//
//        Example Explanation
//        Explanation 1:
//
//        [1, -2, 1] is the largest subarray which sums up to 0.
//        Explanation 2:
//
//        No subarray sums up to 0.

//https://www.scaler.com/academy/mentee-dashboard/class/155293/assignment/problems/27742

import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) {
        //int[] A = {1, -2, 1, 2};
        int[] A = {1, 4,-5,0};
        System.out.println(solveMin(A));
    }

    public static int solve(int[] A) {
        int length = A.length;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0, maxLen = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i];
            if (sum == 0) maxLen = i + 1;
            else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));

            } else {
                map.put(sum, i);
            }
        }
        return (int) maxLen;
    }

    public static int solveMin(int[] A) {
        int length = A.length;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            sum += A[i];
            if (sum == 0) minLen = Math.min(minLen,i+1);
            else if (map.containsKey(sum)) {
                minLen = Math.min(minLen, i - map.get(sum));
                map.put(sum, i);

            } else {
                map.put(sum, i);
            }
        }
        return (int) minLen;
    }

}
