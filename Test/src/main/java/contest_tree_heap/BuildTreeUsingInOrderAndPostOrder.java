package contest_tree_heap;

import java.util.ArrayList;

public class BuildTreeUsingInOrderAndPostOrder {

    public void buildTree(ArrayList<Integer> inorder,ArrayList<Integer> postOrder) {
        buildTreeNode(inorder,postOrder,0,inorder.size()-1,0,postOrder.size()-1);
    }

    public TreeNode buildTreeNode(ArrayList<Integer> inorder, ArrayList<Integer> postOrder,
                              int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postOrder.get(postEnd));
        int rootIdx = inorder.indexOf(root.val);
        int leftSubTreeCount = rootIdx-inStart;

        root.left = buildTreeNode(inorder,postOrder, inStart,rootIdx-1,postStart,postStart+leftSubTreeCount-1);
        root.right = buildTreeNode(inorder,postOrder,rootIdx+1, inEnd,postStart+leftSubTreeCount,postEnd-1);

        return root;
    }
}
