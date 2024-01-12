package com.adv.tree;

import java.util.ArrayList;
/*
Problem Description
        Given a binary tree, return the inorder traversal of its nodes' values.

        NOTE: Using recursion and stack are not allowed.


        Problem Constraints
        1 <= number of nodes <= 10^5


        Input Format
        First and only argument is root node of the binary tree, A.


        Output Format
        Return an integer array denoting the inorder traversal of the given binary tree.


        Example Input
        Input 1:

        1
        \
        2
        /
        3
        Input 2:

        1
        / \
        6   2
        /
        3


        Example Output
        Output 1:

        [1, 3, 2]
        Output 2:

        [6, 1, 3, 2]


        Example Explanation
        Explanation 1:

        The Inorder Traversal of the given tree is [1, 3, 2].
        Explanation 2:

        The Inorder Traversal of the given tree is [6, 1, 3, 2].
*/

public class Morris_Inorder_Traversal {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = A;
        while(curr !=null) {
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while(temp.right !=null && temp.right !=curr) {
                    temp = temp.right;
                }
                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else if(temp.right == curr) {
                    temp.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
