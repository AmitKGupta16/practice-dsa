package com.adv.sort;

import java.util.List;

public class FindMedianInTwoArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(b.size() < a.size()) {
            return findMedianSortedArrays(b,a);
        }
        int m = a.size();
        int n = b.size();
        int s=0, e=m;
        int lhalfcnt = (n+m+1)/2;
        while(s<=e) {
            int mid = (s+e)/2;
            int cntA= mid;
            int cntB = lhalfcnt-cntA;
            int l1 = cntA-1 < 0 ? Integer.MIN_VALUE: a.get(cntA-1);
            int l2 = cntB-1 < 0 ? Integer.MIN_VALUE: b.get(cntB-1);
            int r1 = cntA==m ? Integer.MAX_VALUE:a.get(cntA);
            int r2 = cntB==n ? Integer.MAX_VALUE:b.get(cntB);

            if(l1<=r2 && l2<=r1) {
                if((m+n)%2==0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else {
                    return Math.max(l1,l2);
                }
            }else if(l1 > l2){
                e= mid-1;

            }else {
                s= m+1;
            }
        }
        return 0;
    }
}
