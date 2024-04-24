package contest_tree_heap;

public class ValidBinarySearchTree {
    public int isValidBST(TreeNode A) {
        if(checkValid(A,Long.MIN_VALUE,Long.MAX_VALUE)) return 1;
        return 0;
    }

    public boolean checkValid(TreeNode A,long min,long max) {
        if(A== null) return true;
        if(A.val <= min || A.val >= max) return false;
        boolean left = checkValid(A.left,min,A.val);
        boolean right = checkValid(A.right,A.val, max);
        return (left && right);
    }




}
