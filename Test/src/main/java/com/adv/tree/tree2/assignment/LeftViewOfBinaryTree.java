package com.adv.tree.tree2.assignment;

import com.adv.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(A);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=1;i<=size;i++) {
                TreeNode poll = queue.poll();
                if(i==1) {
                    res.add(poll.val);
                }
                if(poll.left !=null) queue.add(poll.left);
                if(poll.right !=null) queue.add(poll.right);
            }
        }
        return res;

    }
}
