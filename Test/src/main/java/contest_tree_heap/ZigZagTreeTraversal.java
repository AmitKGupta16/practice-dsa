package contest_tree_heap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ZigZagTreeTraversal {

    public ArrayList<ArrayList<Integer>> zigZag(TreeNode A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        int level =0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null) queue.add(poll.left);
                if(poll.right !=null) queue.add(poll.right);
            }
            if(level % 2 != 0) {
                reverse(list);
                output.add(list);
                level++;
            } else {
                output.add(list);
                level++;
            }
        }

        return output;
    }

    public void reverse (ArrayList<Integer> A) {
        int start =0, end = A.size()-1;
        while(start < end) {
            int temp = A.get(start);
            A.set(start,A.get(end));
            A.set(end,temp);
            start++;end--;
        }
    }
}
