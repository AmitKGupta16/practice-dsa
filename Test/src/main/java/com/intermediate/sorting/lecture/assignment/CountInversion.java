package com.intermediate.sorting.lecture.assignment;

/*Problem Description
        Given an array of integers. Find the Inversion Count in the array.

        Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


        Input Format
        Size of the array
        Sparated values for elements of array


        Output Format
        The Inversion Count of the Array


        Example Input
        5
        2 4 1 3 5


        Example Output
        3


        Example Explanation
        The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3)*/
public class CountInversion {
    public static int getInvCount(int arr[], int n) {
        int count =0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr[i] > arr[j]) count++;
            }
        }
        return count;
    }
}
