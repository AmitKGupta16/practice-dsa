package com.adv.tree.tree1.lecture;

import com.adv.tree.TreeNode;

import java.util.Stack;

public class IterativeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right=node5;
        node3.left=node6;
        iterativeTraversal(root);
    }
    public static void iterativeTraversal(TreeNode root) {
        Stack<PairTask> stack = new Stack<>();
        PairTask pairTask = new PairTask(root);
        stack.push(pairTask);
        while(!stack.empty()){
            PairTask pair = stack.peek();
            if(pair.task ==1) {
                stack.peek().task++;
                if(pair.node.left!=null){
                    stack.push(new PairTask(pair.node.left));
                }
            }else if(pair.task ==2) {
                stack.peek().task++;
                System.out.print(pair.node.val + " ");
            } else if(pair.task==3) {
                stack.peek().task++;
                if(pair.node.right!=null){
                    stack.push(new PairTask(pair.node.right));
                }
            }else if(pair.task==4) {
                stack.pop();
            }
        }
    }
}

class PairTask{
    TreeNode node;
    int task;
    public PairTask(TreeNode node) {
        this.node = node;
        task=1;
    }
}
