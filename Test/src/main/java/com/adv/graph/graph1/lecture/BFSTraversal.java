package com.adv.graph.graph1.lecture;

import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> list = createAdjancyList(4);
        boolean[] visited = new boolean[4+1];
        Arrays.fill(visited,false);
        BFS(0,list,visited,4);

    }

    public static List<List<Integer>> createAdjancyList(int N) {
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            List<Integer> paths = new ArrayList<>();
            paths.add(i+1);
            paths.add(i+2);
            adjancyList.add(paths);
        }
        List<Integer> paths = new ArrayList<>();
        paths.add(N);
        //paths.add(N-(N-1));
        adjancyList.add(paths);

        return adjancyList;
    }

    public static boolean BFS(int src,List<List<Integer>> adjancyList,boolean[] visited,int d) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        visited[src] = true;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(poll != adjancyList.size()) {
                for (Integer val : adjancyList.get(poll)) {
                    if (visited[val] == false) {
                        queue.add(val);
                        visited[val] = true;
                    }
                }
            }
        }
        return visited[d];
    }

}
