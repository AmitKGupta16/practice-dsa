package com.adv.graph.graph3.assignment;

import java.util.*;
import java.util.stream.Collectors;

/*Problem Description
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format
The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format
Return an integer representing the minimal cost required.



Example Input
Input 1:

A = 4
B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

A = 4
B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output
Output 1:

        6
Output 2:

        6


Example Explanation
Explanation 1:

We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
Explanation 2:

We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.*/
public class CommutableIslands {
    public static void main(String[] args) {
        int A = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 1)),
                new ArrayList<>(List.of(2, 3, 4)),
                new ArrayList<>(List.of(1, 4, 3)),
                new ArrayList<>(List.of(4, 3, 2)),
                new ArrayList<>(List.of(1, 3, 10))));
        System.out.println(solve(A, B));
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Pair>> adjancyList = createAdjancyList(A, B);
        boolean[] visited = new boolean[A + 1];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        minHeap.add(new Pair(1, 0));
        int ans = 0;
        while (!minHeap.isEmpty()) {
            Pair poll = minHeap.poll();
            if (visited[poll.dest]) continue;
            visited[poll.dest] = true;
            ans += poll.weight;
            for (Pair edge : adjancyList.get(poll.dest)) {
                if (visited[edge.dest]) continue;
                minHeap.add(new Pair(edge.dest, edge.weight));
            }
        }
        return ans;
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

class Pair {
    int dest, weight;

    public Pair(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}
