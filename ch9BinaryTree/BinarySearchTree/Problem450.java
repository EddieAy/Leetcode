package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;

public class Problem450 {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else {
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            root.val = minValue(root.right);

            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }

    private int minValue(TreeNode node) {
        int val = node.val;
        while (node != null){
            val = node.val;
            node = node.left;
        }
        return val;
    }


}
