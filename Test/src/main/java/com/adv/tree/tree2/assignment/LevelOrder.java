package com.adv.tree.tree2.assignment;

/*Problem Description
        Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



        Problem Constraints
        1 <= number of nodes <= 10^5



        Input Format
        First and only argument is root node of the binary tree, A.



        Output Format
        Return a 2D integer array denoting the level order traversal of the given binary tree.



        Example Input
        Input 1:

        3
        / \
        9  20
        /  \
        15   7
        Input 2:

        1
        / \
        6   2
        /
        3


        Example Output
        Output 1:

        [
        [3],
        [9, 20],
        [15, 7]
        ]
        Output 2:

        [
        [1]
        [6, 2]
        [3]
        ]


        Example Explanation
        Explanation 1:

        Return the 2D array. Each row denotes the traversal of each level.*/

import com.adv.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            ArrayList<Integer> list =new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left !=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
            }
            res.add(list);
        }
        return res;

    }
}
