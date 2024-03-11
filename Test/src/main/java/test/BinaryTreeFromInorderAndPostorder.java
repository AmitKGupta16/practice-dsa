/*
package test;

import com.adv.tree.TreeNode;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int inOrderLength = A.size();
        int postOrderLength = B.size();
        TreeNode root = new TreeNode(B.get(postOrderLength-1));
        int index = search(A, root.val);
        root.left = buildTree(0,index-1,A,B);
        root.right = buildTree(index+1,inOrderLength-1,A,B);
        return null;
    }

    public TreeNode buildTree(int is,int ie,int ps,int pe, ArrayList<Integer> A, ArrayList<Integer> B) {


        return null;
    }

    public int search(ArrayList<Integer> A, int val) {
        return A.indexOf(val);
    }
}
*/
