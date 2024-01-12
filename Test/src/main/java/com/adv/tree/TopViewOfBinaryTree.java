package com.adv.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/*Problem Description
        Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

        The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

        Return the nodes in any order.



        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000

        0 <= node values <= 10^9



        Input Format
        First and only argument is head of the binary tree A.



        Output Format
        Return an array, representing the top view of the binary tree.



        Example Input
        Input 1:


        1
        /   \
        2    3
        / \  / \
        4   5 6  7
        /
        8
        Input 2:


        1
        /  \
        2    3
        \
        4
        \
        5


        Example Output
        Output 1:

        [1, 2, 4, 8, 3, 7]
        Output 2:

        [1, 2, 3]


        Example Explanation
        Explanation 1:

        Top view is described.
        Explanation 2:

        Top view is described.*/

public class TopViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        HashMap<Integer,ArrayList<Integer>>hm = new HashMap<>();
        Queue<Pair> queue =new ArrayDeque<>();
        Pair pair = new Pair(A,0);
        queue.add(pair);
        int minlvl=0,maxlvl=0;
        while(!queue.isEmpty()) {
            Pair f = queue.poll();
            minlvl = Math.min(minlvl, f.level);
            maxlvl=Math.max(maxlvl,f.level);
            ArrayList<Integer> list;
            if(hm.containsKey(f.level)){
                list = hm.get(f.level);
            }else {
                list = new ArrayList<Integer>();
            }
            list.add(f.node.val);
            hm.put(f.level,list);
            if(f.node.left!=null) {
                queue.add(new Pair(f.node.left,f.level-1));
            }
            if(f.node.right!=null) {
                queue.add(new Pair(f.node.right,f.level+1));
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=minlvl;i<=maxlvl;i++) {
            res.add(hm.get(i).get(0));
        }
        return res;

    }
}
