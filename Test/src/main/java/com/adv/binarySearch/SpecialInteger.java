package com.adv.binarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpecialInteger {
    public static void main(String[] args) {
    System.out.println(solveTwoPointers(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 10));
    System.out.println(solveTwoPointers(new ArrayList<>(List.of(5, 17, 100, 11)), 130));
       // System.out.println(solveTwoPointers(new ArrayList<>(List.of(2, 24, 38, 25, 35, 33, 43, 12, 49, 35, 45, 47, 5, 33)), 249));
    }


    public static int solveTwoPointers(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        long totalSum = 0;
        int start = 0, end = A.size() - 1;
        for (Integer i : A) {
            totalSum += i;
        }
        if (totalSum <= B) return A.size();
        while (start <= end) {
            totalSum -= A.get(start);
            start++;
            if (totalSum <= B) {
                return (end - start) + 1;
            }

        }
        return 0;
    }

    public static int solveBs(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        int start = 1, end = A.size(), ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (addLastXElement(A, mid) <= B) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private static long addLastXElement(ArrayList<Integer> A, int count) {
        int i = count;
        long totalSum = 0L;
        while (i > 0) {
            totalSum += A.get(A.size() - i);
            i--;
        }
        return totalSum;
    }
// 0,1,2,3 .... n-3,n-2,n-1
}
