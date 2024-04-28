package contest_tree_heap;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        if(A==null )return null;
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        A.left = invertTree(A.left);
        A.right = invertTree(A.right);
        return A;
    }
}
