package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class CheckValidBST {
    public static void main(String[] args) {
        int prev = Integer.MIN_VALUE;
        boolean isBST = true;
    }

    public void inorder(TreeNode A,int prev, boolean isBST) {
        if(A==null) return;
        inorder(A.left,prev,isBST);
        if(prev > A.val)  {
            isBST=false;
            return;
        }
        prev = A.val;
        inorder(A.right,prev, isBST);
    }


}
