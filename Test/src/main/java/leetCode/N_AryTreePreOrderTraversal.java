package leetCode;

import java.util.ArrayList;
import java.util.List;

public class N_AryTreePreOrderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<>();
        helper(root, output);
        return output;

    }
    public void helper(Node root, List<Integer> output) {
        if(root == null) return;
        output.add(root.val);
        for(int i=0; i< root.children.size();i++) {

            helper(root.children.get(i), output);
        }

    }
}
