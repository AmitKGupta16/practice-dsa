package leetCode;


import com.adv.tree.TreeNode;

public class MaximumDepthOfTree {
    int leftCount, rightCount;
    public void solve(TreeNode root) {
        if(root !=null) {
            if(leftCount > rightCount) {
                System.out.println(leftCount);
            }else {
                System.out.println(rightCount);
            }
        }

    }

    public void height(TreeNode node) {
        if(node.left != null) {
            leftCount ++;
            height(node.left);
        }
        if(node.right != null) {
            rightCount ++;
            height(node.right);
        }

    }
}
