package leetCode;

import com.adv.tree.Pair;
import com.adv.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left !=null) queue.add(poll.left);
                if(poll.right !=null) queue.add(poll.right);
            }
            if(size >=2) {
                int start =0,end = list.size()-1;
                while (start <= end) {
                    if(list.get(start) != list.get(end)) {
                        return false;
                    }
                }
            } else {
                return true;
            }
        }
    return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftNode , TreeNode rightNode) {
        if(leftNode == null && rightNode ==null) return true;
        if(leftNode == null || rightNode ==null) return false;
        return (leftNode.val == rightNode.val) && check(leftNode.left, rightNode.right)
                && check(leftNode.left, rightNode.right);

    }
}
