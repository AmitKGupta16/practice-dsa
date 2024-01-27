package com.adv.graph.graph1.additional;

import com.adv.graph.graph1.AdjancyList;

import java.util.*;
import java.util.stream.Collectors;

public class PathInDirectedGraph {
    static List<Integer> paths = new ArrayList<>();

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int A = 5;
        List<List<Integer>> adjList =  AdjancyList.constructAdjList(mat,A);
        boolean[] visited = new boolean[A + 1];

        boolean res = DFS( adjList, A);

        boolean resR = DFSR(1, adjList,visited, A);
        int val =0;
    }
    public static boolean DFSR(int src, List<List<Integer>> adjList,boolean[] visited, int A) {
        visited[src] = true;
        for (int val : adjList.get(src)){
            if(!visited[val]){
                visited[val]=true;
                DFSR(val,adjList,visited,A);

            }
        }
        return visited[A];
    }


    public static boolean DFS(List<List<Integer>> adjList, int A) {
        boolean[] visited = new boolean[A + 1];
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty() && !visited[A]) {
            int curr = queue.poll();
            for (int val : adjList.get(curr)){
                if(!visited[val]){
                    queue.add(val);
                    visited[val]=true;
                }
            }
        }
        return visited[A];
    }
}
