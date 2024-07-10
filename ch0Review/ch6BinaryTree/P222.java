package ch0Review.ch6BinaryTree;

public class P222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);

        return  leftNum + rightNum + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root.left,right = root.right;

        while (left != null){
            leftDepth++;
            left = root.left;
        }
        while (right != null){
            rightDepth++;
            right = right.right;
        }
        if(leftDepth == rightDepth){
            return (2 << leftDepth) - 1;
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;

    }
}
