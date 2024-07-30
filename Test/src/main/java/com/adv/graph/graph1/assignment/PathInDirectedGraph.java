package com.adv.graph.graph1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*Problem Description
  Given a directed graph having A nodes labelled from 1 to A containing M edges
  given by matrix B of size M x 2 such that there is an edge directed from node
  B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

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
Return 1 if path exists between node 1 to node A else return 0.



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

        0
Output 2:

        1


Example Explanation
Explanation 1:

The given doens't contain any path from node 1 to node 5 so we will return 0.
Explanation 2:

Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.*/

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {
        List<List<Integer>> input = Arrays.stream(B)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        ArrayList<ArrayList<Integer>> adjList =  createList(input,A);
        boolean[] visited = new boolean[A+1];
        Arrays.fill(visited,false);
        HashSet<Integer> paths = new HashSet<>();
        dfs(1,visited,paths,adjList);

        return paths.contains(A) ? 1:0;
    }

    public void dfs (int node, boolean[] visited, HashSet<Integer> paths,  ArrayList<ArrayList<Integer>> adjList ) {
        paths.add(node);
        visited[node] = true;
        for(int nbr : adjList.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr,visited,paths,adjList);
            }
        }
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
