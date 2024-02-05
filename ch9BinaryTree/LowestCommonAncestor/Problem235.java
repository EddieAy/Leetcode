package ch9BinaryTree.LowestCommonAncestor;

import ch9BinaryTree.TreeNode;

public class Problem235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        if(root.val >= Math.max(p.val,q.val)){//比 两个的最大值大  两个都在它左边
            return lowestCommonAncestor(root.left,p,q);
        } else if (root.val >= Math.min(p.val,q.val)){//  比最大值小  比最小值大  在中间
            return root;
        }else {//  比最小值小   p q一定在它右边
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
