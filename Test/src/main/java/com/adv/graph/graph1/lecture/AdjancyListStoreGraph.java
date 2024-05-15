package com.adv.graph.graph1.lecture;

import java.util.ArrayList;
import java.util.List;

public class AdjancyListStoreGraph {
    public static ArrayList<ArrayList<Integer>> createList(List<List<Integer>> input, int node) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<input.size(); i++) {
            int src = input.get(i).get(0);
            int dest = input.get(i).get(1);
            list.get(src).add(dest);
            list.get(dest).add(src);
        }
        return list;
    }
}
