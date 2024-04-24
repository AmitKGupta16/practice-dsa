package contest_tree_heap;

public class SearchInBST {
    public int solve(TreeNode A, int B) {
        if (A==null) return 0;
        TreeNode temp = A;
        if(temp.val ==B) return 0;
        while(temp != null) {
            if(temp.val == B) return 1;
            else if(B > temp.val) temp= temp.right;
            else temp = temp.left;
        }
        return 0;
    }
}
