package com.intermediate.problemSolving.assignment;
/*Problem Description
        Given a number A. Return 1 if A is prime and return 0 if not.

        Note :
        The value of A can cross the range of Integer.


        Problem Constraints
        1 <= A <= 10^9


        Input Format
        The first argument is a single integer A.


        Output Format
        Return 1 if A is prime else return 0.


        Example Input
        Input 1:
        A = 5
        Input 2:

        A = 10


        Example Output
        Output 1:
        1
        Output 2:

        0


        Example Explanation
        Explanation 1:
        5 is a prime number.
        Explanation 2:

        10 is not a prime number.*/
public class IsPrime {
    public int solve(int A) {
        if(factors(A)==2) return 1;
        else return 0;
    }

    public int factors(int A) {
        int cnt=0;
        for(int index=1;index*index<=A;index++) {
            if(A % index ==0) {
                if(A/index == index) cnt++;
                else cnt=cnt+2;
            }
        }
        return cnt;
    }
}
