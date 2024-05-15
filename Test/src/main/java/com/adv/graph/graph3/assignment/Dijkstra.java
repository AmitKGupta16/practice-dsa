package com.adv.graph.graph3.assignment;

/*
Problem Description
    Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
    You have to find an integer array D of size A such that:
    D[i]: Shortest distance from the C node to node i.
    If node i is not reachable from C then -1.

Note:
    There are no self-loops in the graph.
    There are no multiple edges between two pairs of vertices.
    The graph may or may not be connected.
    Nodes are numbered from 0 to A-1.
    Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.


Problem Constraints
1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

        0 <= C < A



Input Format
The first argument is an integer A, representing the number of nodes in the graph.
The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.


Output Format
Return the integer array D.



        Example Input
Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6]
        [1, 2, 1]
        [2, 5, 1]
        [2, 4, 5]
        [0, 3, 7]
        [0, 1, 1]
        [4, 5, 7]
        [0, 5, 1] ]
C = 4
Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3]
        [0, 1, 9]
        [3, 4, 10]
         [1, 3, 8]   ]
C = 4


Example Output
Output 1:

D = [7, 6, 5, 6, 0, 6]
Output 2:

D = [14, 18, 13, 10, 0]


Example Explanation
Explanation 1:

All Paths can be considered from the node C to get shortest path
Explanation 2:

All Paths can be considered from the node C to get shortest path*/

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {

    public static void main(String[] args) {
        int A = 5, C = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 3, 4)),
                new ArrayList<>(List.of(2, 3, 3)),
                new ArrayList<>(List.of(0, 1, 9)),
                new ArrayList<>(List.of(3, 4, 10)),
                new ArrayList<>(List.of(1, 3, 8))));
        System.out.println(solve(A, B, C));
    }

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        int[] distance = new int[A];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        ArrayList<ArrayList<Pair>> arrayLists = createAdjancyList(A, B);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        minHeap.add(new Pair(C, 0));

        while (!minHeap.isEmpty()) {
            Pair poll = minHeap.poll();
            if (poll.weight > distance[poll.dest]) continue;
            distance[poll.dest] = poll.weight;
            for (Pair pair : arrayLists.get(poll.dest)) {
                minHeap.add(new Pair(pair.dest, poll.weight + pair.weight));
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }
        return (ArrayList<Integer>) Arrays.stream(distance).boxed().collect(Collectors.toList());

    }

    public static ArrayList<ArrayList<Pair>> createAdjancyList(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>(A + 1);
        for (int i = 0; i < A + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edges : B) {
            list.get(edges.get(0)).add(new Pair(edges.get(1), edges.get(2)));
            list.get(edges.get(1)).add(new Pair(edges.get(0), edges.get(2)));
        }
        return list;
    }


}
