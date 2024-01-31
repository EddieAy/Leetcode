package ch9BinaryTree.LevelOrderTraversal;


import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
* */
public class Problem104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0){
                TreeNode temp = queue.poll();
                len--;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth+=1;
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth2(root.left) + 1;
        int rightDepth = maxDepth2(root.right) + 1;
        return Math.max(leftDepth,rightDepth);
    }
}
