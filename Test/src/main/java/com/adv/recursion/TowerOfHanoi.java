package com.adv.recursion;

import java.util.ArrayList;

public class TowerOfHanoi {
    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        towerOfHanoi(A,1,2,3,result);
        return result;
    }

    public static void towerOfHanoi(int A, int src,int aux, int trg,ArrayList<ArrayList<Integer>> result) {
        if(A==0) {
            return;
        }
        towerOfHanoi(A-1, src,trg, aux,result);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A);
        arr.add(src);
        arr.add(trg);
        result.add(arr);
        towerOfHanoi(A-1, aux,src, trg,result);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        towerOfHanoi(3);

    }
}
