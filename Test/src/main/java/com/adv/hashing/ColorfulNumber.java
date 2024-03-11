package com.adv.hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumber {
    public static void main(String[] args) {
        int A =234;
        colorful(A);

    }

    public static int colorful(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        while(A > 0) {
           if(A%10==0) return 0;
            list.add(0,A%10);
            A = A/10;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int s=0;s<list.size();s++) {
            int p=1;
            for(int e =s;e<list.size();e++) {
                p= p * list.get(e);
                if(set.contains(p)) return 0;
                set.add(p);
            }
        }
        return 1;
    }
}
