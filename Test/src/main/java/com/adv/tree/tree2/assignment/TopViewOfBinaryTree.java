package com.adv.tree.tree2.assignment;

import com.adv.tree.TreeNode;

import java.util.*;

public class TopViewOfBinaryTree {
    public ArrayList<Integer> verticalOrderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> hashMap = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        Pair pair = new Pair(A, 0);
        queue.add(pair);
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            ArrayList<Integer> hlist = hashMap.getOrDefault(poll.level, new ArrayList<>());
            hlist.add(poll.node.val);
            hashMap.put(poll.level, hlist);
            if (poll.node.left != null) {
                int lvl = poll.level - 1;
                queue.add(new Pair(poll.node.left, lvl));

            }
            if (poll.node.right != null) {
                int lvl = poll.level + 1;
                queue.add(new Pair(poll.node.right, lvl));
            }
        }
        for (Integer key : hashMap.keySet()) {
            res.add(hashMap.get(key).get(0));
        }
        return res;
    }
}

