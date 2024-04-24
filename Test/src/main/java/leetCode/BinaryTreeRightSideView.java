package leetCode;

import com.adv.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                if(i==size-1) {
                    output.add(poll.val);
                }
                if(poll.left !=null) queue.add(poll.right);
                if(poll.right !=null) queue.add(poll.right);
            }
        }
        return output;
    }
}
