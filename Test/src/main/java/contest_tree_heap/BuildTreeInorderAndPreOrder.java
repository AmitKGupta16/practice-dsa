package contest_tree_heap;

import java.util.ArrayList;

public class BuildTreeInorderAndPreOrder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        return null;
    }

    public TreeNode buildTreeNode(ArrayList<Integer> preorder, ArrayList<Integer> inorder,int preStart,int preEnd,int inStart, int inEnd) {
       if(inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder.get(preStart));
        int rootIdx = inorder.indexOf(root.val);
        int cnt = rootIdx - inStart;
        root.left = buildTreeNode(preorder,inorder,preStart+1,preStart+cnt,inStart,rootIdx-1);
        root.right = buildTreeNode(preorder,inorder,preStart+cnt+1,preEnd,rootIdx+1,inEnd);

        return root;
    }
}
