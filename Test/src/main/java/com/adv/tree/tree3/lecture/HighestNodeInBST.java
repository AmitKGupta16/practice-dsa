package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class HighestNodeInBST {
    public TreeNode highestNode( TreeNode A) {
        if(A == null ) return null;
        TreeNode temp = A;
        while (temp.right !=null) {
            temp = temp.right;
        }
        return temp;
    }
}
