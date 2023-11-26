package com.adv.sort;

public class RotatedArraySearch {
    public static int solve(int[] A, int B) {
        int s=0,e=A.length-1;
        while(s<=e) {
            int mid = (s+e)/2;
            if(A[mid]== B) {
                return mid;
            }
            if(B >= A[0]) { //part1
                if(A[mid] >= A[0]) { //part1
                    if(B < A[mid]) {
                        e = mid-1;
                    }else {
                        s = mid+1;
                    }
                } else { //part2
                    e = mid-1;
                }

            } else { //part2
                if(A[mid] < A[0]) { //part2
                    if(B < A[mid]) {
                        e = mid-1;
                    }else {
                        s = mid+1;
                    }
                }else {
                    s = mid+1;
                }

            }
        }
        return -1;
    }
}
