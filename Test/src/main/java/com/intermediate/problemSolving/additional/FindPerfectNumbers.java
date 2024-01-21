package com.intermediate.problemSolving.additional;

/*Problem Description
        You are given an integer A. You have to tell whether it is a perfect number or not.

        Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

        A proper divisor of a natural number is the divisor that is strictly less than the number.



        Problem Constraints
        1 <= A <= 10^6



        Input Format
        First and only argument contains a single positive integer A.



        Output Format
        Return 1 if A is a perfect number and 0 otherwise.



        Example Input
        Input 1:

        A = 4
        Input 2:

        A = 6


        Example Output
        Output 1:

        0
        Output 2:

        1


        Example Explanation
        Explanation 1:

        For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
        Explanation 2:

        For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.*/
public class FindPerfectNumbers {
    public static void main(String[] args) {
        FindPerfectNumbers findPerfectNumbers = new FindPerfectNumbers();
        System.out.println(findPerfectNumbers.solve(28));
    }
    public int solve(int A) {
        if(sumFactors(A)==A) return 1;
        else return 0;
    }

    public int sumFactors(int A) {
        int sumFactor=1;
        for(int i=2;i*i<=A;i++) {
            if(A%i==0) {
               if(i==A/i) sumFactor+=i;
               else sumFactor+= i+A/i;
            }
        }
        return sumFactor;
    }
}
