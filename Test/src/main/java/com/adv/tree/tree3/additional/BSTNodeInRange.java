package com.adv.tree.tree3.additional;

import com.adv.tree.TreeNode;

public class BSTNodeInRange {
    //32 25 46 17 27 40 49 9 -1 -1 -1 -1 -1 -1 -1 -1 -1
    // 11 26
    public int solve(TreeNode A, int B, int C) {
        int cnt = 0;
        solve(A,B,C,cnt);
        return cnt;
    }

    public void solve(TreeNode A, int B, int C,int cnt) {
        if(A == null) return ;

        if(A.val <=B && A.val >=C) cnt++;
        if(A.left != null) solve(A.left,B,C,cnt);
        if(A.right!=null) solve(A.right,B,C,cnt);
    }
}
