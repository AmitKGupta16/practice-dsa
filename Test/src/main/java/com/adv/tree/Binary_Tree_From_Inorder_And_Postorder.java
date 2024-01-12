package com.adv.tree;

import java.util.ArrayList;

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
        int cnt = rootIdx-is;
        root.left = buildTree(A,B,is,rootIdx-1,ps,ps+cnt-1);
        root.right = buildTree(A,B,rootIdx+1,ie,ps+cnt,pe-1);
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
