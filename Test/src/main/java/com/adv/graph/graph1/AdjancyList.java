package com.adv.graph.graph1;

import java.util.ArrayList;
import java.util.List;

public class AdjancyList {
    public static List<List<Integer>> constructAdjList(ArrayList<ArrayList<Integer>> inputs, int nodeCount) {
        if (inputs.isEmpty()) return new ArrayList<>();
        int edgeCount = inputs.size();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i <= edgeCount; i++) {
            int src = inputs.get(i - 1).get(0);
            int dest = inputs.get(i - 1).get(1);
            adjList.get(src).add(dest);
        }
        return adjList;
    }

    public static List<List<Integer>> constructAdjList(int[][] inputs, int nodeCount) {
        if (inputs.length == 0) return new ArrayList<>();
        int edgeCount = inputs.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i <= edgeCount; i++) {
            int src = inputs[i - 1][0];
            int dest = inputs[i - 1][1];
            adjList.get(src).add(dest);
        }
        return adjList;
    }
}
