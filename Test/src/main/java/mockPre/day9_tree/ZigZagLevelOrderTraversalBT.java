package mockPre.day9_tree;


import java.util.*;

/*
Problem Description
    Given a binary tree, return the zigzag level order traversal of its nodes values.
    (ie, from left to right, then right to left for the next level and alternate between).

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

Example Input
    Input 1:
        3
       / \
      9  20
        /  \
       15   7
    Input 2:
       1
      / \
     6   2
        /
       3


Example Output
    Output 1:
         [
           [3],
           [20, 9],
           [15, 7]
         ]
    Output 2:
         [
           [1]
           [2, 6]
           [3]
         ]

Example Explanation
    Explanation 1:
         Return the 2D array. Each row denotes the zigzag traversal of each level.
* */
public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left9 = new TreeNode(9);
        TreeNode right20 = new TreeNode(20);
        root.left = left9;
        root.right = right20;
        TreeNode left15 = new TreeNode(15);
        TreeNode right17 = new TreeNode(17);
        right20.left =left15;
        right20.right = right17;

/*        TreeNode treeNode = LevelOrderTreeConstruction.constructTree(List.of(129, 97, 98, 93, 106, 27, 61, -1, 173, 40, 78, 22, 152, 99, 114, 47, 69, -1, -1, 110, 144, 14, 56, 165, 174, 49, 1, 57, 126, 123, 100, 30, -1, -1, -1, 161, 13, 139, 2, 85, 128, 119, 177));
        BTreePrinter.printNode(treeNode);
        System.out.println(new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(treeNode));*/
        zigzagLevelOrder(root);
    }


    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int switchIndex =0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            if(switchIndex % 2==0) {
                res.add(list);
                switchIndex++;
            } else {
                reverse(list);
                res.add(list);
                switchIndex++;
            }
        }
        return res;
    }

    public static void reverse(ArrayList<Integer> list) {
        int start =0, end = list.size()-1;
        while(start < end){
            int temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;end--;
        }
    }
}
