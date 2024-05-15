package com.adv.binarySearch.binarySearch1.assignment.lecture;

//Given a sorted array with repetations, count total number of occurence of number.
public class FindOccuranceOfElement {

    public static void main(String[] args) {
        int[] A = {2,2,5,5,5,5,8,8,10,13};
        int B = 5;
        System.out.print(solve(A,B));
    }

    public static int solve(int[] A, int B) {
        int start =0, end = A.length-1;
        int mid = 0;
        int left =0, right = 0;
        while (start <=  end) {
            mid = start + (end-start)/2;
            if(A[mid] == B && (mid==0 || A[mid] > A[mid-1])) {
                left = mid;
            }
            if(A[mid] >= B) {
                end = mid-1;
            } else start = mid+1;
        }
        start =0; end = A.length-1;
        mid =0;
        while (start <=  end) {
            mid = start + (end-start)/2;
            if(A[mid] == B && (mid== A.length-1 || A[mid] > A[mid+1])) {
                return mid;
            }
            if(A[mid] >= B) {
                end = mid-1;
            } else start = mid+1;
        }
        return mid;
    }

}
