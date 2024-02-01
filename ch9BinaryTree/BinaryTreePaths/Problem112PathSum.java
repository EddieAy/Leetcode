package ch9BinaryTree.BinaryTreePaths;

import ch9BinaryTree.TreeNode;

public class Problem112PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        // 目标和
        int targetSum = 22;

        // 调用方法并打印结果
        boolean result = hasPathSum(root, targetSum);
        System.out.println(result);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }

        boolean left = hasPathSum(root.left,targetSum-root.val);

        if(left){
            return true;
        }
        boolean right = hasPathSum(root.right,targetSum-root.val);

        return right;

    }

    public static boolean hasPathSum2(TreeNode root, int targetSum){
        if(root == null) return false;
        return helper(root,targetSum - root.val);
    }

    public static boolean helper(TreeNode root, int targetSum){
        if(root.left == null && root.right == null && targetSum == 0) return true;
        if(root.left == null && root.right == null) return false;

        if(root.left != null){
            if(helper(root.left,targetSum - root.left.val)) return true;
        }

        if(root.right != null){
            if(helper(root.right,targetSum - root.right.val)) return true;
        }

        return false;
    }


}

//
