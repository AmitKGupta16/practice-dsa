package com.adv.tree;

import java.util.*;

/*Problem Description
        Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


        NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



        Problem Constraints
        0 <= number of nodes <= 10^5



        Input Format
        First and only arument is a pointer to the root node of binary tree, A.



        Output Format
        Return a 2D array denoting the vertical order traversal of tree as shown.



        Example Input
        Input 1:

        6
        /   \
        3     7
        / \     \
        2   5     9
        Input 2:

        1
        /   \
        3     7
        /       \
        2         9


        Example Output
        Output 1:

        [
        [2],
        [3],
        [6, 5],
        [7],
        [9]
        ]
        Output 2:

        [
        [2],
        [3],
        [1],
        [7],
        [9]
        ]


        Example Explanation
        Explanation 1:

        First row represent the verical line 1 and so on.*/

public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        int minlvl= 0,maxlvl=0;
        Pair pair = new Pair(A,0);
        queue.add(pair);
        while (!queue.isEmpty()){
           Pair p= queue.poll();
           minlvl= Math.min(minlvl,p.level);
           maxlvl = Math.max(maxlvl, p.level);
            ArrayList<Integer> list;
            if(hm.containsKey(p.level)){
                list = hm.get(p.level);

            } else {
                list = new ArrayList<>();
            }
            list.add(p.node.val);
            hm.put(p.level,list);
            if(p.node.left !=null) {
                queue.add(new Pair(p.node.left,p.level-1));
            }
            if(p.node.right!=null) {
                queue.add(new Pair(p.node.right,p.level+1));
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=minlvl;i<=maxlvl;i++) {
            res.add(hm.get(i));
        }
        return res;
    }
}
