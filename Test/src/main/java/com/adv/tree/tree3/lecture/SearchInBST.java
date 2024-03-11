package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class SearchInBST {
    public boolean search(TreeNode A, int val) {
        TreeNode temp = A;
        while( temp != null ) {
            if (temp.val == val) return true;
            else if (temp.val < val) temp = temp.right;
            else temp = temp.left;
        }
        return false;
    }
}
