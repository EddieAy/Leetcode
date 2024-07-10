package ch0Review.ch6BinaryTree;

public class P654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {

        if(left > right){
            return null;
        }

        int maxValue = nums[left];
        int maxIndex = left;
        for (int i = left + 1; i <= right ; i++) {
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = helper(nums,left,maxIndex - 1 );
        root.right = helper(nums,maxIndex + 1,right);
        return root;
    }
}
