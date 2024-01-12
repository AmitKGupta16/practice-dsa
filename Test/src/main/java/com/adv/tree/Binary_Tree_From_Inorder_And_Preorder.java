package com.adv.tree;

import java.util.ArrayList;
import java.util.List;

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
        int rootIdx1=findIndex(B,root.val);
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
