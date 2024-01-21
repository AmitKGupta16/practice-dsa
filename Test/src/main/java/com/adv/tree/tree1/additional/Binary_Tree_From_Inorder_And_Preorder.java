package com.adv.tree.tree1.additional;

import com.adv.tree.PrintTreeNode;
import com.adv.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
        Given preorder and inorder traversal of a tree, construct the binary tree.

        NOTE: You may assume that duplicates do not exist in the tree.



        Problem Constraints
        1 <= number of nodes <= 10^5



        Input Format
        First argument is an integer array A denoting the preorder traversal of the tree.

        Second argument is an integer array B denoting the inorder traversal of the tree.



        Output Format
        Return the root node of the binary tree.



        Example Input
        Input 1:

        A = [1, 2, 3]
        B = [2, 1, 3]
        Input 2:

        A = [1, 6, 2, 3]
        B = [6, 1, 3, 2]


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

public class Binary_Tree_From_Inorder_And_Preorder {
    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, int pres, int pree, int is, int ie) {
        if (is > ie || pres > pree) {
            return null;
        }
        TreeNode root = new TreeNode(A.get(pres));
        int rootIdx = B.indexOf(root.val);//findIndex(B,root.val);
       // int rootIdx1=findIndex(B,root.val);
        int cnt = rootIdx - is;
        root.left = buildTree(A, B, pres + 1, pres + cnt, is, rootIdx - 1);
        root.right = buildTree(A, B, pres + cnt + 1, pree, rootIdx + 1, ie);
        return root;
    }

    public static int findIndex(ArrayList<Integer> B, int rootVal) {
        for (int i = 0; i < B.size() - 1; i++) {
            if (rootVal == B.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1,2,4,5,7,3,6));
        ArrayList<Integer> B = new ArrayList<>(List.of(4,2,7,5,1,3,6));
        TreeNode rs =  buildTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
        System.out.println(PrintTreeNode.traversePreOrder(rs));
    }
}
