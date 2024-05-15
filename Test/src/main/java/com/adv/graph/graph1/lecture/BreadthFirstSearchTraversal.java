package com.adv.graph.graph1.lecture;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchTraversal {

    boolean[] visited = null;

    public void processDFS(List<List<Integer>> input, int nodeCount) {
        visited = new boolean[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) {
            visited[i] = false;
        }
        visited[0] = true;
        ArrayList<ArrayList<Integer>> adjancyList = AdjancyListStoreGraph.createList(input,nodeCount);
        for(int i =1;i<=nodeCount;i++) {
            if(!visited[i]) dfs(i,adjancyList);
        }
    }

    public void dfs(int node,  ArrayList<ArrayList<Integer>> adjancyList) {
        visited[node] = true;
        for(int edge : adjancyList.get(node)) {
            if(!visited[edge]) dfs(edge,adjancyList);
        }
    }
}
