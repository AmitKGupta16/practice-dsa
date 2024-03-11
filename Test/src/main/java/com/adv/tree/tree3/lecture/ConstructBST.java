package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class ConstructBST {
    public TreeNode construct(int[] arr, int start, int end) {
        if( start > end || start == end ) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = construct(arr, start, mid-1);
        root.right = construct(arr, mid+1, end);
        return root;
    }
}
