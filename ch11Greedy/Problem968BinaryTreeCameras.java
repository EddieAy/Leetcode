package ch11Greedy;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Problem968BinaryTreeCameras {

    int result;
    public int minCameraCover(TreeNode root) {
        result = 0;
        if(traversal(root) == 0){
            result++;
        }
        return result;
    }

    public int traversal(TreeNode cur){
        if (cur == null) return 2;
        int left = traversal(cur.left);
        int right = traversal(cur.right);

        if(left == 2 && right == 2) return 0;
        if(left == 0 || right == 0){
            result++;
            return 1;
        }

        if(left == 1||right==1) return 2;
        return -1;
    }
}
