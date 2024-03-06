package ch12DP;

import ch9BinaryTree.TreeNode;

public class Problem337HouseRobberIII {
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0],result[1]);
    }

    private int[] robSub(TreeNode node) {
        if(node == null){
            return new int[2];
        }
        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        // result[0] 表示不偷当前节点的最大金额，result[1] 表示偷当前节点的最大金额
        int[] result = new int[2];

        //不偷当前节点 可以偷它的子女节点要偷    的偷窃价值之和
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        //偷当前节点  则是  自己的价值  + 子女不偷所对应的价值
        result[1] = node.val + left[0] + right[0];

        return result;
    }
}
