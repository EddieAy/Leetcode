package ch9BinaryTree.SymmetricTree;

import ch9BinaryTree.TreeNode;

public class Problem572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null; // 如果root为空，则subRoot也必须为空
        if (subRoot == null) return true; // 如果subRoot为空，那么它是任何树的子树

        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    public static boolean isSame(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
