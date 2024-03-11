package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class InsertANodeInBST {
    public TreeNode insertNode(TreeNode A, int data) {
        TreeNode insertNode = new TreeNode(data);
        if(A == null) return insertNode;
        TreeNode par = null, temp = A;
        while(temp != null) {
            par = temp;
            if(temp.val < data) temp = temp .right;
            else temp = temp.left;
        }
        if(data <= par.val) par.left = insertNode;
        else par.right = insertNode;
        return A;
    }
}
