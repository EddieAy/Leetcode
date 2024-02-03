package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;
import ch9BinaryTree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem530 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[] {543,384,652,null,445,null,699});
        int ans = new Problem530().getMinimumDifference2(root);
        System.out.println(ans);
    }

    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            minDiff = Math.min(minDiff,Math.abs(res.get(i + 1) - res.get(i)));
        }

        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    int pre = -1;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root){
        inorder2(root);
        return minDiff;
    }

    private void inorder2(TreeNode root) {
        if(root == null) return;
        inorder2(root.left);
        if(pre == -1){
            pre = root.val;
        }else {
            minDiff = Math.min(minDiff,Math.abs(root.val - pre));
            pre = root.val;
        }
        inorder2(root.right);
    }


}
