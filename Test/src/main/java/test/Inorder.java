package test;

import com.adv.tree.TreeNode;

import java.util.ArrayList;

public class Inorder {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(A,list);
        return list;
    }

    public void inorder(TreeNode A,ArrayList<Integer> list) {
        if(A==null) return;
        inorder(A.left,list);
        list.add(A.val);
        inorder(A.right,list);
    }
}
