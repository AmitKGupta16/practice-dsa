package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class SmallestNodeInBST {
    public TreeNode smallestNode(TreeNode A) {
        if (A == null) return null;
        TreeNode temp = A;
        while( temp.left !=null) {
            temp = temp.left;
        }
        return temp;
    }
}
