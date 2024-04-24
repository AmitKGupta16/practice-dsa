package com.adv.heap.heap1.lecture;

import java.util.ArrayList;
import java.util.List;

public class InsertElementIntoMinHeap {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(List.of(5,12,20,25,13,24,22,35));
        insert(list,10);
        System.out.println(list);
    }

    public static ArrayList<Integer> insert (ArrayList<Integer> list, int insert) {
        list.add(insert);
        int eleIdx = list.size()-1;
        while (eleIdx >= 0) {
            int parentIdx = (eleIdx -1)/2;
            if(list.get(parentIdx) > list.get(eleIdx)) {
                swap(list,parentIdx,eleIdx);
                eleIdx = parentIdx;
            } else break;
        }
        return list;
    }

    public static void swap(ArrayList<Integer> list, int srcIdx, int destIdx) {
        int temp = list.get(srcIdx);
        list.set(srcIdx,list.get(destIdx));
        list.set(destIdx,temp);
    }
}
