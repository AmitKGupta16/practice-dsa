package com.adv.tree.tree2.assignment;

import com.adv.tree.TreeNode;

/*Problem Description
        Given a root of binary tree A, determine if it is height-balanced.

        A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



        Problem Constraints
        1 <= size of tree <= 100000



        Input Format
        First and only argument is the root of the tree A.



        Output Format
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



        Example Input
        Input 1:

        1
        / \
        2   3
        Input 2:


        1
        /
        2
        /
        3


        Example Output
        Output 1:

        1
        Output 2:

        0


        Example Explanation
        Explanation 1:

        It is a complete binary tree.
        Explanation 2:

        Because for the root node, left subtree has depth 2 and right subtree has depth 0.
        Difference = 2 > 1.*/
public class BalanceTree {
    public static void main(String[] args) {

    }

    //optimized
    public static int isBalanced(TreeNode A) {
        return helper(A).isBal ? 1 : 0;
    }

    public static PairHelper helper(TreeNode A) {
        if (A == null) {
            return new PairHelper(0, true);
        }
        PairHelper pairHelperLeft = helper(A.left);
        PairHelper pairHelperRight = helper(A.right);

        if (pairHelperLeft.isBal == false || pairHelperRight.isBal == false) {
            return new PairHelper(-1, false);
        } else if (Math.abs(pairHelperLeft.height - pairHelperRight.height) > 1) {
            return new PairHelper(-1, false);
        } else {
            return new PairHelper(Math.max(pairHelperLeft.height, pairHelperRight.height) + 1, true);
        }
    }

    //BF Approach
    public boolean isBalance(TreeNode A) {
        if(A == null) return true;
        int lh = height(A.left);
        int rh = height(A.right);
        if(Math.abs(rh-lh) > 1) {
            return false;
        } else {
            return isBalance(A.left) && isBalance(A.right);
        }
    }

    public int height(TreeNode A) {
        if (A == null) return 0;
        int leftHeight = height(A.left);
        int rightHeight = height(A.right);
        return Math.max(leftHeight,rightHeight) +1;
    }
}

class PairHelper {
    int height;
    boolean isBal;

    public PairHelper(int height, boolean isBal) {
        this.height = height;
        this.isBal = isBal;
    }

}
