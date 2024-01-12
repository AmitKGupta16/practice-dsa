package com.adv.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*Problem Description
    Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



    Problem Constraints
    1 <= number of nodes <= 105



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

    Return the 2D array. Each row denotes the traversal of each level.

 */

public class Level_Order_Traversal {
    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        java.util.Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        node9.left =node15;
        TreeNode node20 = new TreeNode(20);
        TreeNode node7 = new TreeNode(7);
        node20.right=node7;
        root3.left = node9;
        root3.right = node20;
        System.out.println(solve(root3));
    }
}

