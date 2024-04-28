package contest_tree_heap;

public class BalancedBinaryTree {
    public int isBalanced(TreeNode A) {
        return 0;
    }

    public int height(TreeNode A) {
        if(A == null) return 0;
        int leftHeight = height(A.left);
        int rightHeight = height(A.right);
        return Math.max(leftHeight,rightHeight) +1;
    }
}
