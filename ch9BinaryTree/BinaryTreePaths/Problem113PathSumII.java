package ch9BinaryTree.BinaryTreePaths;

import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem113PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        pathSum(root,22);
    }

    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> cur = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;

        helper(root,targetSum);
        return res;
    }

    private static void helper(TreeNode root, int targetSum) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum){
            res.add(new LinkedList<>(cur));
        }

        helper(root.left,targetSum - root.val);
        helper(root.right,targetSum - root.val);
        cur.removeLast();


/*        if (root.left != null){
            helper(root.left,targetSum - root.val);
        }
        if(root.right != null){
            helper(root.right,targetSum - root.val);
        }*/
    }

}
