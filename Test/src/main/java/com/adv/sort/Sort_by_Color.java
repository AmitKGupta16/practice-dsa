package com.adv.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort_by_Color {
    public static int[] dnf(int[] A) {
        int low =0;
        int hi = A.length-1;
        int mid=0,swap=0;

        while(mid<=hi) {
            switch (A[mid]) {
                case 0:
                    swap = A[low];
                    A[low] = A[mid];
                    A[mid] = swap;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap = A[mid];
                    A[mid] = A[hi];
                    A[hi] = swap;
                    hi--;
                    break;
            }

        }
        return A;
    }

    public static int partation(int[] arr,int first, int last) {
        Random random = new Random();
        //int pivot = arr[first];
        int pivot = random.nextInt(arr.length);
        int l= first+1;
        int r = last;
        while(l<=r) {
            if (arr[l] <= pivot) {
                l++;
            } else if (arr[r] > pivot) {
                r--;
            } else {
                int swap = arr[l];
                arr[l] = arr[r];
                arr[r] = swap;
                l++;
                r--;
            }
        }
        int swap = arr[first];
        arr[first] = arr[r];
        arr[r] = swap;
        return r;
    }

    public static int[]  quickSort(int[] arr,int first,int last) {
        if (first >= last) { return arr;}
            int partation = partation(arr, first, last);
            quickSort(arr, first, partation - 1);
            quickSort(arr, partation + 1, last);
            return arr;
    }

    public static void main(String[] args) {
        int[] arr= {0, 1, 2, 0, 1, 2};
       // int[] arr1 = quickSort(arr,0,5);
        int[] arr1 = dnf(arr);
        Arrays.stream(arr1).forEach(val -> System.out.println(val));
    }
}
