package ch0Review.ch6BinaryTree;

public class P513 {

    int curHeight = 0;
    int curVal = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return curVal;
    }

    private void dfs(TreeNode root, int height) {
        if(root == null) return;
        height++;
        dfs(root.left,height);
        dfs(root.right,height);
        if(height > curHeight){
            curHeight = height;
            curVal = root.val;
        }
    }
}
