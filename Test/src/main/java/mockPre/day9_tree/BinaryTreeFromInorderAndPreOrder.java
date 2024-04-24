package mockPre.day9_tree;


import java.util.ArrayList;

/*
Problem Description
    Given preorder and inorder traversal of a tree, construct the binary tree.
    NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First argument is an integer array A denoting the preorder traversal of the tree.
    Second argument is an integer array B denoting the inorder traversal of the tree.

Output Format
    Return the root node of the binary tree.

Example Input
    Input 1:
        A = [1, 2, 3]
        B = [2, 1, 3]
    Input 2:
        A = [1, 6, 2, 3]
        B = [6, 1, 3, 2]

Example Output
    Output 1:

           1
          / \
         2   3
    Output 2:

           1
          / \
         6   2
            /
           3


Example Explanation
    Explanation 1:
        Create the binary tree and return the root node of the tree.
* */
public class BinaryTreeFromInorderAndPreOrder {

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

        return null;
    }

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder,
                                  int preStart, int preEnd, int inStart, int inEnd) {
        if(inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder.get(preStart));
      //  int inorderIndex = findIndex(inorder, root.data);
        int inorderIndex = inorder.indexOf(root.val);
        int count = inorderIndex -inStart;
        root.left = buildTree(preorder,inorder,preStart+1,count+preStart,inStart,inorderIndex-1);
        root.right = buildTree(preorder,inorder,count+preStart+1,preEnd,inorderIndex+1,inEnd);
        return root;
    }

    public int findIndex(ArrayList<Integer> inorder, int data) {
        return inorder.indexOf(data);
    }


/*    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, int pres, int pree, int is, int ie) {
        if (is > ie || pres > pree) {
            return null;
        }
        TreeNode root = new TreeNode(A.get(pres));
        int rootIdx = B.indexOf(root.val);//findIndex(B,root.val);
        int cnt = rootIdx - is;
        root.left = buildTree(A, B, pres + 1, pres + cnt, is, rootIdx - 1);
        root.right = buildTree(A, B, pres + cnt + 1, pree, rootIdx + 1, ie);
        return root;
    }*/
}
