package com.adv.tree.tree1.lecture;

import com.adv.tree.TreeNode;

public class PreOrderTraversal {
    public void preOrder(TreeNode root) {
        if(root ==null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
