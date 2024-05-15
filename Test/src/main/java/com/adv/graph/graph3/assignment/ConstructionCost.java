package com.adv.graph.graph3.assignment;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*Problem Description
    Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
    Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

    NOTE: Return the answer modulo 10^9+7 as the answer can be large.



Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 10^9



Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]



Output Format
Return an integer denoting the minimum construction cost.



Example Input
Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output
Output 1:

        9
Output 2:

        37


Example Explanation
Explanation 1:

We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
we can reach the 1st node from 2nd and 3rd node using only these two edges.
        So, the total cost of costruction is 9.
Explanation 2:

We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.*/


public class ConstructionCost {
    public static void main(String[] args) {
        int A = 3;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 14)),
                new ArrayList<>(List.of(2, 3, 7)),
                new ArrayList<>(List.of(3, 1, 2))));
        System.out.println(solve(A, B));
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Pair>> arrayLists = createAdjancyList(A, B);
        boolean[] visited = new boolean[A + 1];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        minHeap.add(new Pair(1, 0));
        long totalCost = 0;
        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            if (visited[pair.dest]) continue;
            totalCost += pair.weight % 1000000007;
            visited[pair.dest] = true;
            for (Pair edge : arrayLists.get(pair.dest)) {
                if (visited[edge.dest]) continue;
                minHeap.add(edge);
            }

        }
        return (int) (totalCost % 1000000007);
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
