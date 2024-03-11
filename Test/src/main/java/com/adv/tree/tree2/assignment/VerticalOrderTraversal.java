package com.adv.tree.tree2.assignment;

import com.adv.tree.TreeNode;

import java.util.*;
/*Problem Description
        Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


        NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



        Problem Constraints
        0 <= number of nodes <= 105



        Input Format
        First and only arument is a pointer to the root node of binary tree, A.



        Output Format
        Return a 2D array denoting the vertical order traversal of tree as shown.



        Example Input
        Input 1:

        6
        /   \
        3     7
        / \     \
        2   5     9
        Input 2:

        1
        /   \
        3     7
        /       \
        2         9


        Example Output
        Output 1:

        [
        [2],
        [3],
        [6, 5],
        [7],
        [9]
        ]
        Output 2:

        [
        [2],
        [3],
        [1],
        [7],
        [9]
        ]


        Example Explanation
        Explanation 1:

        First row represent the verical line 1 and so on.*/

public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> hashMap = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        Pair pair = new Pair(A, 0);
        queue.add(pair);
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            ArrayList<Integer> hlist = hashMap.getOrDefault(poll.level, new ArrayList<>());
            hlist.add(poll.node.val);
            hashMap.put(poll.level, hlist);
            if (poll.node.left != null) {
                int lvl = poll.level - 1;
                queue.add(new Pair(poll.node.left, lvl));

            }
            if (poll.node.right != null) {
                int lvl = poll.level + 1;
                queue.add(new Pair(poll.node.right, lvl));
            }
        }
        for (Integer key : hashMap.keySet()) {
            res.add(hashMap.get(key));
        }
        return res;
    }
}

class Pair {
    int level;
    TreeNode node;

    public Pair(TreeNode node, int level) {
        this.level = level;
        this.node = node;
    }

}
