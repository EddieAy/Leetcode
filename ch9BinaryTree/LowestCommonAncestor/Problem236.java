package ch9BinaryTree.LowestCommonAncestor;

import ch9BinaryTree.TreeNode;
import ch9BinaryTree.TreeUtil;

public class Problem236 {

    public static void main(String[] args) {
        Problem236 solution = new Problem236();

        // 构建二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // 定义p和q
        TreeNode p = root.left; // 节点 5
        TreeNode q = root.left.right.right; // 节点 1

        // 寻找最近公共祖先
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode t1 = lowestCommonAncestor(root.left, p, q);
        TreeNode t2 = lowestCommonAncestor(root.right, p, q);
        if (t1 != null && t2 != null) {
            return root;
        }
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        return null;

    }

}
