package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode A= new TreeNode(1);
        validBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean validBST(TreeNode A, int min, int max) {
        if (A == null) return true;
        if(A.val <= min || A.val > max ) return false;
        boolean left = validBST(A.left,min, A.val);
        boolean right = validBST(A.right, A.val, max);
        return left && right;

    }
}
