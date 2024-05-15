package contest_tree_heap;

import java.util.ArrayDeque;
import java.util.Queue;

public class Mirror {

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _6 = new TreeNode(6);
        _1.left = _2;
        _1.right =_3;
        _2.left =_4;
        _2.right=_5;
        _3.right=_6;
        solve(_1);


    }
    public static Long solve(TreeNode A) {
        if (A == null) return 0L;
        mirror(A);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        Long sum =0L;
        int first =1;
        int last =1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            if(size ==1) {
                TreeNode poll = queue.poll();
                if(poll.left !=null) queue.add(poll.left);
                if(poll.right !=null) queue.add(poll.right);

                sum += poll.val * poll.val;// % 1000000007;

            }
            else {
                for(int i=0;i<size;i++) {
                    TreeNode poll = queue.poll();
                    if(poll.left !=null) queue.add(poll.left);
                    if(poll.right !=null) queue.add(poll.right);
                    if(i==0)  first = poll.val;
                    if(i==size-1) {
                        last = poll.val;
                        sum += first * last;
                    }
                }
                //sum += first * last; //% 1000000007;
            }

        }
        return sum % 1000000007 ;
    }

    public static void mirror(TreeNode A) {
        if (A == null) return;
        TreeNode left = A.left;
        TreeNode right = A.right;
        A.left = right; A.right = left;
        mirror(A.left);
        mirror(A.right);
    }
}

