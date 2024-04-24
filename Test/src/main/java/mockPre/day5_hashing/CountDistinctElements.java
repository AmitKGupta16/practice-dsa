package mockPre.day5_hashing;

import java.util.HashMap;
import java.util.HashSet;

/*Problem Description
        Given an array A of N integers, return the number of unique elements in the array.


        Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^9


        Input Format
        First argument A is an array of integers.


        Output Format
        Return an integer.


        Example Input
        Input 1:
        A = [3, 4, 3, 6, 6]
        Input 2:
        A = [3, 3, 3, 9, 0, 1, 0]


        Example Output
        Output 1:
        3
        Output 2:
        4


        Example Explanation
        For Input 1:
        The distinct elements of the array are 3, 4 and 6.
        For Input 2:
        The distinct elements of the array are 3, 9, 0 and 1.*/
//https://www.scaler.com/academy/mentee-dashboard/class/118936/assignment/problems/27502
public class CountDistinctElements {
    public static void main(String[] args) {
        int[] A= {3, 4, 3, 6, 6};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for( int i=0;i<A.length;i++) {
            set.add(A[i]);

        }
        int count=0;
        for(Integer val :set) {
          count++;
        }
        return count;
    }
}
