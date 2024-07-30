package com.adv.arrays.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOneToNumber {
    public static void main(String[] args) {
        ArrayList<Integer>  A = new ArrayList<>(List.of(0,0,0,9,9,9));
        System.out.println(plusOne(A));
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        if(A == null) return null;
        int length = A.size();
        ArrayList<Integer> output = new ArrayList<>();
        if(length ==1 && A.get(0) < 9) {
            output.add(A.get(0)+1);
            return output;
        }
        int start =0,i=0;
        while(length > i && A.get(i)==0) {
            start++;
            i++;
        }
        int carry =1;
        for(int j = length-1;j>=start;j--) {
            int sum = carry + A.get(j);
            carry = sum/10;
            int rem = sum %10;
            output.add(rem);
        }
        if(carry > 0) output.add(carry);
        Collections.reverse(output);

        return output;
    }
}
