package com.adv;

import java.util.Arrays;
import java.util.Collections;

public class Print1ToAFunction {

    public static void solve(int A) {
        if(A>0) {
            System.out.print(A + " ");
            solve(A-1);
        }
        System.out.println();


    }
    public static void main(String[] args) {
        solve(16);
    }
}
