package test;

import com.adv.tree.TreeNode;

import java.util.Stack;

public class IterativeInorderTraversal {
    public void iterativeInorder(TreeNode A) {
        Stack<PairTask> stack = new Stack<>();
        PairTask pairTask = new PairTask(A);
        stack.push(pairTask);
        while (!stack.empty()) {
            PairTask peek = stack.peek();
            if (peek.task == 1) {
                stack.peek().task++;
                if (peek.curr.left != null) {
                    PairTask left = new PairTask(peek.curr.left);
                    stack.push(left);
                }
            } else if (peek.task == 2) {
                stack.peek().task++;
                System.out.println(peek.curr.val);
            } else if (peek.task == 3) {
                stack.peek().task++;
                if (peek.curr.right != null) {
                    PairTask right = new PairTask(peek.curr.right);
                    stack.push(right);
                }
            } else if (peek.task == 4) {
                stack.pop();
            }

        }


    }
}

class PairTask {
    TreeNode curr;
    int task;

    public PairTask(TreeNode node) {
        curr = node;
        task = 1;
    }
}
