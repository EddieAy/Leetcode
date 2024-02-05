package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;

public class Problem538 {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }

    int sum = 0;
    public void helper(TreeNode root){
        if (root == null) return;

        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
