package com.adv.tree.tree2.assignment;

import com.adv.tree.TreeNode;
import com.sun.source.tree.NewArrayTree;

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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(A);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=1;i<=size;i++) {
                TreeNode poll = queue.poll();
                if(i==size) {
                    res.add(poll.val);
                }
                if(poll.left !=null) queue.add(poll.left);
                if(poll.right !=null) queue.add(poll.right);

            }
        }
        return res;

    }
}
