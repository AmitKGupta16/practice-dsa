package com.adv.binarySearch.binarySearch1.assignment.lecture;

//Given a sorted array of unique elements, search for a target & return its index, if not present return -1.
public class SearchElementInUniqueArray {

    public int search(int[] A, int B) {
        int start = 0, end = A.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (A[mid] == B) {
                return mid;
            }
            if (A[mid] < B) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
    //T.C = O(logn) , S.C = O(logn)
}
