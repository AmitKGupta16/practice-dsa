package contest_tree_heap;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public List<Integer> iterativeInorderTraversal(TreeNode root) {
        Stack<PairTask> stack = new Stack<>();
        PairTask task = new PairTask(root);
        stack.push(task);
        List<Integer> output = new ArrayList<>();
        if( root == null)  return output;
        while(!stack.isEmpty()) {
            PairTask peek= stack.peek();
            if(peek.task ==1) {
                stack.peek().task++;
                if (peek.node.left !=null ) stack.push(new PairTask(peek.node.left));
            } else if (peek.task == 2) {
                stack.peek().task++;
                output.add(peek.node.val);
            } else if (peek.task ==3) {
                stack.peek().task++;
                if(peek.node.right !=null) stack.push((new PairTask(peek.node.right)));
            } else if (peek.task ==4){
                stack.pop();
            }
        }
        return output;
    }
}
