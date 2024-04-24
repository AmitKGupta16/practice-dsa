package mockPre.day1_array;

/*
Problem Description
    Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

Problem Constraints
    1 <= |A| <= 100000

Input Format
    First and only argument is the vector A

Output Format
     Returns one integer, the answer to the question

Example
    Input 1:
        A = [0, 1, 0, 2]
    Input 2:
        A = [1, 2]

Example
    Output 1:
        1
    Output 2:
        0

Example
    Explanation 1:
        1 unit is trapped on top of the 3rd element.
    Explanation 2:
        No water is trapped.
* */
//https://www.scaler.com/academy/mentee-dashboard/class/126650/assignment/problems/47
public class RainWaterTrapped {
    public int trapWater(int[] A) {
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
