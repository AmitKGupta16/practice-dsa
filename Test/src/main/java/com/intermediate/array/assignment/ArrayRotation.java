package com.intermediate.array.assignment;

import java.util.ArrayList;
import java.util.List;
/*Problem Description
        Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.


        Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <=10^9
        1 <= B <= 10^9


        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.


        Output Format
        Return the array A after rotating it B times to the right


        Example Input
        Input 1:

        A = [1, 2, 3, 4]
        B = 2
        Input 2:

        A = [2, 5, 6]
        B = 1


        Example Output
        Output 1:

        [3, 4, 1, 2]
        Output 2:

        [6, 2, 5]


        Example Explanation
        Explanation 1:

        Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
        Explanation 2:

        Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]*/

public class ArrayRotation {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4));
        int B = 2;
        solve(A,B);
        System.out.println(A);

    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        B = B % N;
        reverse(A,0,N-1);
        reverse(A,0,B-1);
        reverse(A,B,N-1);
        return A;
    }

    public static void reverse(ArrayList<Integer> A,int L,int R) {
        int i=L,j=R;
        int temp=0;
        while(i<j) {
           temp = A.get(i) ;
           A.set(i,A.get(j));
           A.set(j,temp);
           i++;j--;
        }
    }
}
