package com.adv.tree.tree1.assignment;

import com.adv.tree.TreeNode;

import java.util.ArrayList;

/*Problem Description
        Given the inorder and postorder traversal of a tree, construct the binary tree.

        NOTE: You may assume that duplicates do not exist in the tree.



        Problem Constraints
        1 <= number of nodes <= 10^5



        Input Format
        First argument is an integer array A denoting the inorder traversal of the tree.

        Second argument is an integer array B denoting the postorder traversal of the tree.



        Output Format
        Return the root node of the binary tree.



        Example Input
        Input 1:

        A = [2, 1, 3]
        B = [2, 3, 1]
        Input 2:

        A = [6, 1, 3, 2]
        B = [6, 3, 2, 1]


        Example Output
        Output 1:

        1
        / \
        2   3
        Output 2:

        1
        / \
        6   2
        /
        3


        Example Explanation
        Explanation 1:

        Create the binary tree and return the root node of the tree.*/

public class Binary_Tree_From_Inorder_And_Postorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildTree(A,B,0,A.size()-1,0,B.size()-1);
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B,int is, int ie, int ps, int pe) {
        if(is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(B.get(pe));
        int rootIdx = findRootIndex(root.val, A);
        //Number of node left subtree (is, rootIdx-1)
        // b-a +1 ( rootidx-1-is+1) =  rootidx-is
        int cnt = rootIdx-is;
        root.left = buildTree(A,B,is,rootIdx-1,ps,ps+cnt-1);
        root.right = buildTree(A,B,rootIdx+1,ie,ps+cnt,pe- 1);
        return root;

    }

    public int findRootIndex(int rootVal, ArrayList<Integer> A){
        for(int i=0;i<A.size();i++) {
            if(rootVal == A.get(i)){
                return i;
            }
        }
        return -1;
    }

}
