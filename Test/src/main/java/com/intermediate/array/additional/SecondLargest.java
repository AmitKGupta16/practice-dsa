package com.intermediate.array.additional;

import java.util.ArrayList;

public class SecondLargest {
    public int solve(ArrayList<Integer> A) {
        int max=Integer.MAX_VALUE;
        int secondMax = max;
        for(Integer val : A) {
            if(max < val) max= val;
            if(secondMax < max) secondMax = max;
        }
        return 0;
    }
}
