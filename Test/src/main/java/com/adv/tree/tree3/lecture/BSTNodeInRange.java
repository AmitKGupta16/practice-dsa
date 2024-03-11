package com.adv.tree.tree3.lecture;

import com.adv.tree.TreeNode;

public class BSTNodeInRange {
    public int solve(TreeNode A, int B, int C) {
        if (A == null) return 0;
        int cnt = (A.val >= B && A.val <= C) ? 1 : 0;
        int leftCnt = A.left != null ? solve(A.left, B, C) : 0;
        int rightCnt = A.right != null ? solve(A.right, B, C) : 0;
        return cnt + leftCnt + rightCnt;
    }
}
