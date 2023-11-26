package com.adv.sort;

public class SquareRootInteger {
    public static int solve(int A) {
        if(A==0 || A==1) {
            return A;
        }
        int s=1,e=A,ans=0;
        while(s<=e) {
            int mid= (s+e)/2;
            if(mid*mid==A) {
                return mid;
            } else if(mid*mid < A) {
                ans =mid;
                s=mid+1;
            }else {
                e =mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        solve(2);
    }
}
