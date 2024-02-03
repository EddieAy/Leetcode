package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;
import ch9BinaryTree.TreeUtil;

public class Problem98 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{5,1,4,null,null,3,6});
        System.out.println(new Problem98().isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        // 根节点的值 不仅需要 比左边的 最大值大 要比右边的最小值小

        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private boolean helper(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;
        if(root.val < maxValue && root.val > minValue){
            return helper(root.left,root.val,minValue) && helper(root.right,maxValue,root.val);
        }else {
            return false;
        }
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root){
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;
        boolean l = inorder(root.left);

        if(root.val <= pre){
            return false;
        }
        pre = root.val;

        boolean r = inorder(root.right);

        return l && r;
    }

}
