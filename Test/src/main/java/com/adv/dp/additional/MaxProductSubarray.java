package com.adv.dp.additional;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
        Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

        Return an integer corresponding to the maximum product possible.

        NOTE: Answer will fit in 32-bit integer value.



        Problem Constraints
        1 <= N <= 5 * 10^5

        -100 <= A[i] <= 100



        Input Format
        First and only argument is an integer array A.



        Output Format
        Return an integer corresponding to the maximum product possible.



        Example Input
        Input 1:

        A = [4, 2, -5, 1]
        Input 2:

        A = [-3, 0, -5, 0]


        Example Output
        Output 1:

        8
        Output 2:

        0


        Example Explanation
        Explanation 1:

        We can choose the subarray [4, 2] such that the maximum product is 8.
        Explanation 2:

        0 will be the maximum product possible.*/
public class MaxProductSubarray {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(1,2,3));
        //subArray(input);
        maxProduct(input,3);

    }
    //generate subArray
    public static void subArray(final List<Integer> A) {
        for(int i=0;i<A.size();i++){
            for(int j=i;j<A.size();j++) {
                for(int s=i;s<=j;s++) {
                    System.out.print(A.get(s) + " ");
                }
                System.out.println();
            }
        }
     }

     public static int maxProduct(List<Integer> A,int N) {
        if(N==1) {
            return A.get(0);
        }
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            maxProduct = Math.max(maxProduct,maxProduct(A,N-1));
        }
        return maxProduct;
     }
}
