package com.adv.graph.graph1.additional;

import com.adv.graph.graph1.AdjancyList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        solve(5,new ArrayList<ArrayList<Integer>>());

    }
    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[][] mat = {{1, 2},
        {2, 3},
        {3, 4},
        {4, 5},{5,1}};
        List<List<Integer>> adjList =  AdjancyList.constructAdjList(mat,5);
        Set<Integer> paths = new HashSet<>();
        boolean[] visited = new boolean[A + 1];
        paths.clear();
       boolean yes = hasCycle(1,adjList,visited,paths);
       int val =0;
       return 0;
    }


    public static boolean hasCycle(int src,List<List<Integer>> adjList,boolean[] visited, Set<Integer> paths) {
        visited[src] = true;
        paths.add(src);
        for(Integer val :adjList.get(src)) {
            if(visited[val]) {
                return true;
            }
            visited[val] = true;
            if(hasCycle(val,adjList,visited,paths)) return true;
        }
        paths.remove(src);
        return false;
    }

}
