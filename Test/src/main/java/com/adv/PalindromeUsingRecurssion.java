package com.adv;

public class PalindromeUsingRecurssion {
    public static int solve(String A) {
        return palindrome(A,0,A.length()-1);
    }

    public static int palindrome(String A, int i, int j) {
        if(i>=j) {
            return 1;
        }
        if(A.charAt(i)==A.charAt(j)){
            return palindrome(A,i+1,j-1);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solve("JAMAN"));
    }
}
