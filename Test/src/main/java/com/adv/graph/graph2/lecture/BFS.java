package com.adv.graph.graph2.lecture;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void bfsGraph(List<List<Integer>> input, int node) {
        ArrayList<ArrayList<Integer>> adjList = createList(input,node);
        boolean[] visited = new boolean[node +1];
        Queue<Integer> queue = new ArrayDeque<>();
        int startNode = 1;
        queue.add(startNode);
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            visited[poll] = true;
            for (int nbr :adjList.get(poll)) {
                if (!visited[nbr]) queue.add(nbr);
            }
        }
    }


    //Undirected graph adjancy list.
    public static ArrayList<ArrayList<Integer>> createList(List<List<Integer>> input, int node) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= node; i++) list.add(new ArrayList<>());

        for(int i=0;i<input.size(); i++) {
            int src = input.get(i).get(0);
            int dest = input.get(i).get(1);
            list.get(src).add(dest);
            list.get(src).add(dest);

        }
        return list;
    }
}
