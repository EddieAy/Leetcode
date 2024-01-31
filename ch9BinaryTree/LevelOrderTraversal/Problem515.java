package ch9BinaryTree.LevelOrderTraversal;


import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
* */
public class Problem515 {
    public static void main(String[] args) {

    }


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0){
                TreeNode temp = queue.poll();
                max = Math.max(max,temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                len--;
            }
            res.add(max);
        }
        return res;
    }
}
