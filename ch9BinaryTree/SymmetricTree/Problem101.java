package ch9BinaryTree.SymmetricTree;

import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given the root of a binary tree,
* check whether it is a mirror of itself (i.e., symmetric around its center).*/

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right ==null) return false;
        TreeNode right = invertTree(root.right);

        return isSame(root.left,right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSame(left.left,right.left) && isSame(left.right,right.right);
    }

    public static TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }


}
