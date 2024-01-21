package com.adv.tree.tree1.lecture;

import com.adv.tree.TreeNode;

public class PostOrderTraversal {
    public void postOrder(TreeNode root) {
        if(root ==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");

    }
}
