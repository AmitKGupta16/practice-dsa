package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    }
    public int minAbsDiff(ArrayList<Integer> A) {
        Collections.sort(A);
        int i = 0, j = A.size() - 1;
        int minDiff = Integer.MAX_VALUE;
        while (i < j) {
            int diff = Math.abs(A.get(j) - A.get(i));
            minDiff = Math.min(minDiff,diff);
            i++;j--;
        }
        return minDiff;
    }
}
