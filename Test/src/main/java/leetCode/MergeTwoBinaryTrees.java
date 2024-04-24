package leetCode;

import com.adv.tree.TreeNode;



public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);

    }

    public TreeNode merge(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode ==null) return null;
        else if(leftNode == null ) return rightNode;
        else if (rightNode == null) return leftNode;
        TreeNode newRoot = new TreeNode(leftNode.val + rightNode.val);
        newRoot.left = merge(leftNode.left, rightNode.left);
        newRoot.right = merge(leftNode.right, rightNode.right);
        return newRoot;

    }
}
