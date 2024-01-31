package ch9BinaryTree.InvertBinaryTree;

import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given the root of a binary tree, invert the tree, and return its root*/
public class Problem226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();

            while (len > 0){
                TreeNode curr = queue.poll();

                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                len--;
            }
        }
        return root;
    }
}
