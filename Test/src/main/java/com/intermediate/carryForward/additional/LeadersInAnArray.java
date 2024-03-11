package com.intermediate.carryForward.additional;

import java.util.ArrayList;

/*Problem Description
        Given an integer array A containing N distinct integers,
         you have to find all the leaders in array A.
          An element is a leader if it is strictly greater than all the elements to its right side.

        NOTE: The rightmost element is always a leader.


        Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^8


        Input Format
        There is a single input argument which a integer array A


        Output Format
        Return an integer array denoting all the leader elements of the array.


        Example Input
        Input 1:
        A = [16, 17, 4, 3, 5, 2]
        Input 2:
        A = [5, 4]


        Example Output
        Output 1:
        [17, 2, 5]
        Output 2:
        [5, 4]


        Example Explanation
        Explanation 1:
        Element 17 is strictly greater than all the elements on the right side to it.
        Element 2 is strictly greater than all the elements on the right side to it.
        Element 5 is strictly greater than all the elements on the right side to it.
        So we will return these three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
        Explanation 2:
        Element 5 is strictly greater than all the elements on the right side to it.
        Element 4 is strictly greater than all the elements on the right side to it.
        So we will return these two elements i.e [5, 4], we can also any other ordering.*/
public class LeadersInAnArray {
    public static void main(String[] args) {
        //solve(new int[] {16, 17, 4, 3, 5, 2});
        solve(new int[] {5,4});
    }
    public static int[] solve(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<A.length;i++) {
            boolean flag=false;
            for(int j=i+1;j<A.length;j++) {
                if(A[i] > A[j]){
                    flag =true;
                } else {
                    flag=false;
                    break;
                }
            }
            if(flag) list.add(A[i]);
        }
        list.add(A[A.length-1]);
        int[] res = new int[list.size()];
        int i=0;
        for (int val: list){
            res[i]= val;
            i++;
        }
       // System.out.println(list);

        return res;

    }
}
