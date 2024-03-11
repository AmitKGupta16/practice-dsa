package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AdjancyList {
    public static void main(String[] args) {
        int[][] inputs = {{1,4},{2,0},{3,2},{4,3},{2,4},{3,0}};
        int nodeCount=5;
        int edgeCount = inputs.length;

        List<List<Integer>> adjList = new ArrayList();
        for(int i=0;i<nodeCount;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edgeCount;i++) {
            int src = inputs[i][0];
            int dest = inputs[i][1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        System.out.println(adjList);

       // bfs(adjList,1,0);
        boolean[] visited = new boolean[adjList.size()];
        DFS(1,adjList,visited);
        int val =0;

    }

    public static boolean bfs(List<List<Integer>> adjList,int s, int d) {
        boolean[] visited = new boolean[adjList.size()];
        Deque<Integer> qeque = new ArrayDeque<>();
        qeque.add(s);
        visited[s] = true;
        while(!qeque.isEmpty()) {
            int curr = qeque.poll();
            System.out.print(curr + " ");
            for(int val : adjList.get(curr)) {
                if(!visited[val]) {
                    qeque.add(val);
                    visited[val] = true;
                }
            }
        }
        return visited[d];
    }

    public static void DFS(int src,List<List<Integer>> adjList,boolean[] visited) {
        visited[src]= true;
        for(int val : adjList.get(src)) {
            if(!visited[val]) {
                DFS(val,adjList,visited);
            }
        }

    }
}
