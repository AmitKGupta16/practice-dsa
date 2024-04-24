package mockPre.day4_BinarySearch;


import java.util.Arrays;

/*
Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:

 The minimum distance will be 1.
* */
public class AggressiveCows {

    // https://www.scaler.com/academy/mentee-dashboard/class/126658/assignment/problems/4129?navref=cl_tt_nv
    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int start = Integer.MAX_VALUE, end = A[A.length - 1] - A[0];
        for (int i = 1; i < A.length; i++) {
            start = Math.min(start, (A[i] - A[i - 1]));
        }
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(check(A,mid,B)) {
                start = mid+1;
                ans = mid;
            }else end = mid-1;
        }
        return ans;
    }

    public boolean check(int[] A, int mid, int B) {
        int count = 1;
        int pos = A[0];
        for (int i = 1; i < A.length; i++) {
            if ((A[i] -pos) >= mid) {
                count++;
                pos = A[i];
                if(count ==B) return true;
            }
            if (count > B) break;
        }
        return false;
    }

    public int solve1(int[] A, int B) {
        int length = A.length;
        int maxDistance = A[length-1] -A[0];
        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<length;i++) {
            minDistance = Math.min(maxDistance,(A[i] - A[i-1]));
        }
        int ans =0;
        while(minDistance <= maxDistance) {
            int mid = minDistance + (maxDistance - minDistance)/2;
            if(check(A,mid,B)) {
                minDistance = mid+1;
                ans = mid;
            } else {
                maxDistance = mid-1;
            }
        }
        return ans;
    }
    public boolean check1(int[] A, int mid, int B) {
        int count=1;
        int pos= A[0];
        for(int i=1;i< A.length;i++) {
            if((A[i]-pos) >=  mid) {
                count++;
                pos = A[i];
                if(count ==B) return true;
            }
        }
        return false;
    }

}
