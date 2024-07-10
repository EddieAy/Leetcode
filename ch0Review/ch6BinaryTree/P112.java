package ch0Review.ch6BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class P112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return helper(root,targetSum - root.val);
    }

    private boolean helper(TreeNode root, int leftVal) {
        if(root.left == null && root.right == null && leftVal == 0) return true;
        if(root.left == null && root.right == null) return false;

        if(root.left != null){
            if(helper(root.left,leftVal - root.left.val)){
                return true;
            }
        }

        if(root.right != null){
            if(helper(root.right,leftVal - root.right.val)){
                return true;
            }
        }
        return false;
    }

/*    private boolean dfs(TreeNode root, Deque<Integer> path, int targetSum) {
        if(root.left == null && root.right == null){
            int sum = 0;
            for (Integer num:path){
                sum+=num;
            }
            return sum == targetSum;
        }

        path.add(root.val);
        dfs(root.left,path,targetSum);
        dfs(root.right,path,targetSum);
        path.removeLast();
    }*/
}
