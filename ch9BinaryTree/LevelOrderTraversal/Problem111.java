package ch9BinaryTree.LevelOrderTraversal;

import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0){
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                len--;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth+=1;
        }
        return depth;
    }

    public int minDepth2(TreeNode root){
        if (root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }
        else if (root.left != null && root.right == null){
            return minDepth2(root.left) + 1;
        }else if (root.right != null && root.left == null){
            return minDepth2(root.right) + 1;
        }else{
            return Math.min(minDepth2(root.left),minDepth2(root.right)) + 1;
        }
    }
}
