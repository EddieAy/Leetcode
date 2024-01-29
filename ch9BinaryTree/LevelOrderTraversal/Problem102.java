package ch9BinaryTree.LevelOrderTraversal;

import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public static void main(String[] args) {
        // 创建测试用例的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);

        // 打印结果
        for(List<Integer> level : result) {
            for(int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> res1 = new ArrayList<>();

            while (len > 0){
                TreeNode temp = queue.poll();
                res1.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                len--;
            }
            res.add(res1);
        }
        return res;
    }
}
