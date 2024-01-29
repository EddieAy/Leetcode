package ch9BinaryTree.LevelOrderTraversal;

import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
* Given the root of a binary tree,
* return the average value of the nodes on each level in the form of an array.
* Answers within 10-5 of the actual answer will be accepted.
* */

public class Problem637 {
    public static void main(String[] args) {
        System.out.println(3.0 / 2);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int count = len;
            int sum = 0;
            while (len > 0){
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                sum += temp.val;
                len--;
            }
            res.add(((double)sum / count));
        }
        return res;
    }
}
