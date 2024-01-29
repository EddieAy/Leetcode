package ch9BinaryTree.LevelOrderTraversal;

import ch9BinaryTree.TreeNode;

import java.util.*;

public class Problem107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }
}
