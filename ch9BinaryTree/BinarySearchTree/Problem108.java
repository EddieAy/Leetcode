package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;

public class Problem108 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length);
    }

    private static TreeNode helper(int[] nums, int start, int end) {
        if(end - start == 1){
            return new TreeNode(nums[start]);
        }
        if(end == start){
            return null;
        }
        int midIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = helper(nums,start,midIndex);
        root.right = helper(nums,midIndex + 1,end);
        return root;
    }
}
