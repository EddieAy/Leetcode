package ch9BinaryTree.BalancedBinaryTree;

import ch9BinaryTree.TreeNode;

public class Problem110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        // 测试
        System.out.println(isBalanced2(root)); // 应该输出 false
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    public static boolean isBalanced2(TreeNode root){
        return height(root) != -1;
    }

    public static int height(TreeNode root){
        if (root == null) return 0;
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        } else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
