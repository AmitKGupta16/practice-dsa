package com.adv.tree.tree1.additional;

/*Problem Description
        Given a binary tree, return the Postorder traversal of its nodes values.



        Problem Constraints
        1 <= number of nodes <= 10^5



        Input Format
        First and only argument is root node of the binary tree, A.



        Output Format
        Return an integer array denoting the Postorder traversal of the given binary tree.



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

        [3, 2, 1]
        Output 2:

        [6, 3, 2, 1]


        Example Explanation
        Explanation 1:

        The Preoder Traversal of the given tree is [3, 2, 1].
        Explanation 2:

        The Preoder Traversal of the given tree is [6, 3, 2, 1]*/

import com.adv.tree.TreeNode;

import java.util.ArrayList;

public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(A,res);
        return res;
    }

    public void postorder(TreeNode A, ArrayList<Integer> res){
        if(null == A) {
            return;
        }
        postorder(A.left,res);
        postorder(A.right,res);
        res.add(A.val);
    }
}
