package com.adv.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*Problem Description
        Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

        Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000

        0 <= node values <= 10^9



        Input Format
        First and only argument is head of the binary tree A.



        Output Format
        Return an array, representing the right view of the binary tree.



        Example Input
        Input 1:


        1
        /   \
        2    3
        / \  / \
        4   5 6  7
        /
        8
        Input 2:


        1
        /  \
        2    3
        \
        4
        \
        5


        Example Output
        Output 1:

        [1, 3, 7, 8]
        Output 2:

        [1, 3, 4, 5]


        Example Explanation
        Explanation 1:

        Right view is described.
        Explanation 2:

        Right view is described.*/

public class RightViewofBinarytree {

    public static void main(String[] args) {
        //1 15 2 -1 -1 -1 -1
        TreeNode root = new TreeNode(1);
        TreeNode node15 = new TreeNode(15);
        TreeNode node2 = new TreeNode(2);
        TreeNode node_1 = new TreeNode(-1);
        node15.left = node_1;
        node15.right = node_1;
        node2.left = node_1;
        node2.right =node_1;
        root.left=node15;
        root.right = node2;
        solve(root);

    }
    public static ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for(int cnt=1;cnt<=levelSize;cnt++){
                TreeNode temp =queue.poll();
                if(cnt==levelSize) {
                    list.add(temp.val);
                }
                if(temp.left!=null && temp.left.val!=-1) {
                    queue.add(temp.left);
                }
                if(temp.right!=null && temp.right.val!=-1) {
                    queue.add(temp.right);
                }
            }
        }
        return list;
    }
}
