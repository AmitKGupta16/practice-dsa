package leetCode;

import com.adv.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                if(poll.right != null) queue.add(poll.right);
                if(poll.left != null) queue.add(poll.left);
                if(poll.left == null && poll.right ==null) return poll.val;
            }
        }
        return -1;
    }
}
