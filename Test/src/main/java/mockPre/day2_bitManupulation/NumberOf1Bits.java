package mockPre.day2_bitManupulation;


/*
Problem Description
    Write a function that takes an integer and returns the number of 1 bits present in its binary representation.

Problem Constraints
    1 <= A <= 10^9

Input Format
    First and only argument contains integer A

Output Format
     Returns an integer

Example
    Input 1:
        11
    Input 2:
        6

Example
    Output 1:
        3
    Output 2:
        2

Example
    Explanation 1:
        11 is represented as 1011 in binary.
    Explanation 2:
        6 is represented as 110 in binary.
    * */
public class NumberOf1Bits {

    public int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) > 0) count++;
           // A = A/2; is same as A = A >> 1 - A left sift 1
            A = A >> 1;
        }
        return count;
    }
}
