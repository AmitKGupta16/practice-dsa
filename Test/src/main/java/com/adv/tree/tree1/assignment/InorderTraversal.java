package com.adv.tree.tree1.assignment;

import com.adv.tree.TreeNode;

import java.util.ArrayList;

/*Problem Description
        Given a binary tree, return the inorder traversal of its nodes' values.



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

        The Inorder Traversal of the given tree is [6, 1, 3, 2].*/

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(A,res);
        return res;

    }
    public void inorder(TreeNode A, ArrayList<Integer> res) {
        if(null== A) {
            return;
        }
        inorder(A.left,res);
        res.add(A.val);
        inorder(A.right,res);
    }
}
