package contest_tree_heap;

public class PathSum {
    public int hasPathSum(TreeNode A, int B) {
        if (A == null) return 0;

        int left = hasPathSum(A.left,B-A.val);
        int right = hasPathSum(A.right,B-A.val);
        if((left == B) || (right == B)) return 1;
        return 0;
    }
}
