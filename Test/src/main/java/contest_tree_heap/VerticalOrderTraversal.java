package contest_tree_heap;

import com.adv.tree.Pair;
import com.adv.tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if(A == null) return output;
        PairNode node = new PairNode(A,0);
        Queue<PairNode> queue = new ArrayDeque<>();
        queue.add(node);
        Map<Integer,ArrayList<Integer>> hashMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            PairNode poll= queue.poll();
            ArrayList<Integer> list= null;
            list.add(poll.node.val);
            if(hashMap.containsKey(poll.index)) {
                list = hashMap.get(poll.index);
            } else {
                list=new ArrayList<>();
            }
            list.add(poll.node.val);
            hashMap.put(poll.index,list);
            if(poll.node.left !=null) queue.add(new PairNode(poll.node.left,poll.index -1));
            if(poll.node.right !=null) queue.add(new PairNode(poll.node.right,poll.index +1));
        }
        for(Integer key :hashMap.keySet()) {
            output.add(hashMap.get(key));
        }
        return output;
    }
}
class PairNode {
    TreeNode node;
    int index;

    public PairNode(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
