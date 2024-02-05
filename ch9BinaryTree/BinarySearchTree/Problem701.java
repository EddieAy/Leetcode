package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;
import ch9BinaryTree.TreeUtil;

public class Problem701 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{4,2,7,1,3});
        root = insertIntoBST(root,5);
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }

        if(root.val < val){
/*            if(root.right != null){
                root.right = insertIntoBST(root.right,val);
            }else {
                TreeNode temp = new TreeNode(val);
                root.right = temp;
            }*/
            root.right = insertIntoBST(root.right,val);
        }else {
/*            if(root.left != null){
                root.left = insertIntoBST(root.left,val);
            }else {
                TreeNode temp = new TreeNode(val);
                root.left = temp;
            }*/
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
