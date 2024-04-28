package contest_tree_heap;

public class NextPointerBinaryTree {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left,right,next;

    public TreeLinkNode(int val) {
        this.val = val;
        this.left = this.right = this.next =null;
    }
}
