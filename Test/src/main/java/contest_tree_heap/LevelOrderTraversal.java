package contest_tree_heap;

import java.util.*;

public class LevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i <= size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            output.add(list);
        }
        return output;
    }


    public ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = queue.poll();
                if (i == 1) {
                    output.add(poll.val);
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return output;
    }

    public ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = queue.poll();
                if (i == size) {
                    output.add(poll.val);
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return output;
    }

    public ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = queue.poll();
                if (i == size) {
                    output.add(poll.val);
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return output;
    }



}
