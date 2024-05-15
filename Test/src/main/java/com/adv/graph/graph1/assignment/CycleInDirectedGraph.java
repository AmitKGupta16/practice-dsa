package com.adv.graph.graph1.assignment;

/*Problem Description
      Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents
      the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 10^5

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

A = 5
B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:

A = 5
B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]


Example Output
Output 1:

        1
Output 2:

        0


Example Explanation
Explanation 1:

The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

The given graph doesn't contain any cycle.*/

import com.adv.graph.graph1.lecture.AdjancyListStoreGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CycleInDirectedGraph {
    static boolean hasCycle = false;
    public static void main(String[] args) {
      int A=2;
      int[][] B = {{1,2}};
      System.out.println(solve(A,B));
    }
    public static int solve(int A, int[][] B) {
        List<List<Integer>> list = Arrays.stream(B)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        ArrayList<ArrayList<Integer>>  adjList = createList(list,A);
        boolean[] visited = new boolean[A+1];
        Arrays.fill(visited,false);
        HashSet<Integer> paths = new HashSet<>();
        for(int i=1;i<=A;i++) {
            if (!visited[i]) dfs(i,adjList,visited,paths);

        }
        return hasCycle ? 1: 0;
    }

    public static void dfs (int edge,ArrayList<ArrayList<Integer>>  adjList, boolean[] visited, HashSet<Integer> paths) {
        paths.add(edge);
        visited[edge] = true;
        for(int value : adjList.get(edge)) {
            if(paths.contains(value)) hasCycle = true;
            if(!visited[value]) dfs(value,adjList,visited,paths);
        }
        paths.remove(edge);
    }

    public static ArrayList<ArrayList<Integer>> createList(List<List<Integer>> input, int node) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= node; i++) list.add(new ArrayList<>());

        for(int i=0;i<input.size(); i++) {
            int src = input.get(i).get(0);
            int dest = input.get(i).get(1);
            list.get(src).add(dest);
        }
        return list;
    }
}
