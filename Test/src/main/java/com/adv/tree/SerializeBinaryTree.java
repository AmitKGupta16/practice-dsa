package com.adv.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/*
  Problem Description
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.

Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105



Input Format
Only argument is a A denoting the root node of a Binary Tree.



Output Format
Return an integer array denoting the Level Order Traversal of the given Binary Tree.



Example Input
Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output
Output 1:

 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2:

 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Explanation
Explanation 1:

 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
*
* */

public class SerializeBinaryTree {
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode node = new TreeNode(-1);
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode curr= queue.poll();
            result.add(curr.val);
            if(curr.val >-1) {
                if (curr.left != null) {
                    queue.add(curr.left);
                } else {
                    queue.add(node);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                } else {
                    queue.add(node);
                }
            }
        }
        return result;
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
