package com.intermediate.problemSolving.additional;
/*Problem Description
        You will be given an integer n. You need to return the count of prime numbers less than or equal to n.


        Problem Constraints
        0 <= n <= 10^3


        Input Format
        Single input parameter n in function.


        Output Format
        Return the count of prime numbers less than or equal to n.


        Example Input
        Input 1:
        19
        Input 2:
        1


        Example Output
        Output 1:
        8
        Output 2:
        0


        Example Explanation
        Explanation 1:
        Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19
        Explanation 2:
        There are no primes <= 1*/
public class CountOfPrimes {
    public static void main(String[] args) {
        CountOfPrimes countOfPrimes = new CountOfPrimes();
        System.out.println(countOfPrimes.solve(19));
        System.out.println(countOfPrimes.solve(1));
    }
    public int solve(int A) {
        int countPrime=0;
        for(int i=1;i<=A;i++) {
            if(isPrime(i)) countPrime++;
        }
        return countPrime;
    }

    public boolean isPrime(int A) {
        if(factors(A)==2) return true;
        else return false;

    }
    public int factors(int A) {
        int cnt=0;
        for(int i=1;i*i<=A;i++) {
            if(A % i== 0) {
                if (i == A / i) cnt++;
                else cnt=cnt+2;
            }
        }
        return cnt;
    }
}
