package com.adv.arrays.array1.assignment;

/*Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



        Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

        1
Output 2:

        0


Example Explanation
Explanation 1:

        1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.*/
public class RainWaterTrapped {
    public int trap(final int[] A) {
        // int ans=0;
        // int water=0;
        // int N = A.length;
        // int[] lmax = new int[N];
        // int[] rmax = new int[N];

        // lmax[0] =0;
        // for(int i=1;i<N;i++) {
        //     lmax[i] = Math.max(lmax[i-1], A[i-1]);
        // }
        // rmax[N-1] =0;
        // for(int i=N-2;i>=0;i--) {
        //     rmax[i] = Math.max(rmax[i+1],A[i+1]);
        // }

        // for(int i=1;i<N-1;i++) {
        //     water = Math.min(lmax[i],rmax[i])-A[i];
        //     if(water >0) {
        //         ans += water;
        //     }
        // }
        // return ans;
        int length = A.length, waterTrapped = 0;
        int ans =0;
        int[] lMax = new int[length];
        int[] rMax = new int[length];
        lMax[0] = 0;
        for(int i=1;i<length;i++) {
            lMax[i] = Math.max(lMax[i-1],A[i-1]);
        }
        rMax[length-1] = 0;
        for(int i = length -2; i>=0;i--) {
            rMax[i] = Math.max(rMax[i+1],A[i+1]);
        }
        for(int i=1;i<length-1;i++) {
            waterTrapped = Math.min(lMax[i],rMax[i]) - A[i];
            if (waterTrapped > 0) ans +=waterTrapped;
        }
        return ans;
    }
}