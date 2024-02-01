package ch9BinaryTree.SumofLeftLeaves;

import ch9BinaryTree.TreeNode;

public class Problem404 {
    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        return mySum(root,sum);
    }

    public static int mySum(TreeNode root,int sum){
        if(root == null) return sum;

        if (root.left != null && (root.left.left == null && root.left.right == null) ){
            sum+=root.left.val;
        }

        sum = mySum(root.left,sum);
        sum = mySum(root.right,sum);

        return sum;
    }
}
