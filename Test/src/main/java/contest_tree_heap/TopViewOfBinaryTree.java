package contest_tree_heap;

import com.adv.tree.TreeNode;

import java.util.*;

public class TopViewOfBinaryTree {

    public ArrayList<Integer> verticalOrderTraversal(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        if (A == null) return output;
        Queue<PairNode> queue = new ArrayDeque<>();
        queue.add(new PairNode(A, 0));
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        while (queue.isEmpty()) {
            ArrayList<Integer> list = null;
            PairNode poll = queue.poll();
            list = map.getOrDefault(poll.index, new ArrayList<>());
            list.add(poll.node.val);
            map.put(poll.index, list);
            if (poll.node.left !=null) queue.add(new PairNode(poll.node.left, poll.index-1));
            if (poll.node.right !=null) queue.add(new PairNode(poll.node.right, poll.index+1));
        }
        for(Integer key : map.keySet()) {
            output.add(map.get(key).get(0));
        }
        return output;
    }
}
