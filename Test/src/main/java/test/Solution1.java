package test;

import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 7, 5};
        int[] arr = {0};
        System.out.println( subarraySum(arr, 1, 0));

    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList();
        list.add(-1);
        list.add(-1);
        if (arr.length == 0) return list;
        if (arr[0] == s) {
            list.set(0, 1);
            list.set(1, 1);
            return list;

        }
        int start = 0, end = 1;
        int sum = arr[0] + arr[1];
        while (start < end && end < n - 1) {
            if (sum == s) {
                list.set(0, start+1);
                list.set(1, end+1);
                return list;
            }
            sum += arr[++end];
            if (sum > s) {
                sum -= arr[start];
                start++;
            }
        }
        return list;

    }
}
