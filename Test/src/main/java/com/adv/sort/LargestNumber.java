package com.adv.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem Description
        Given an array A of non-negative integers, arrange them such that they form the largest number.

        Note: The result may be very large, so you need to return a string instead of an integer.

        Problem Constraints
        1 <= len(A) <= 100000
        0 <= A[i] <= 2*109

        Input Format
        The first argument is an array of integers.

        Output Format
        Return a string representing the largest number.

        Example Input
        Input 1:

        A = [3, 30, 34, 5, 9]
        Input 2:

        A = [2, 3, 9, 0]

        Example Output
        Output 1:
        "9534330"
        Output 2:
        "9320"

        Example Explanation
        Explanation 1:

        Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
        Explanation 2:

        Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

*/
public class LargestNumber {
    public static String largestNumber(ArrayList<Integer> A) {
        List<Integer> list = A.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String ab = o1 + String.valueOf(o2);
                String ba = String.valueOf(o2) + o1;
                return ab.compareTo(ba) > 0?-1:1;
            }
        }).collect(Collectors.toList());
        StringBuilder res = new StringBuilder();
        for(Integer val : list) {
           res.append(val);
        }
        if(res.charAt(0)=='0') {
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new ArrayList<>(List.of(3, 30, 34, 5, 9))));

    }
}

