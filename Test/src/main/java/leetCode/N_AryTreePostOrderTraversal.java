package leetCode;

import java.util.ArrayList;
import java.util.List;

public class N_AryTreePostOrderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<>();
        helper(root,output);
        return output;
    }
    public void helper(Node root, List<Integer> output) {
        if(root == null) return;
        for(int i=0; i<root.children.size();i++) {
            helper(root.children.get(i),output);
        }
        output.add(root.val);
    }
}
class Node {
    int val;
    List<Node> children;
    public Node(int val) {
        this.val = val;
    }
}
