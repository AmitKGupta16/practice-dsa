package com.adv.tree.tree1.lecture;

import com.adv.tree.TreeNode;

public class InorderTraversal {
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+ " ");
        inorder(root.right);
    }
}
