package ch9BinaryTree.BinarySearchTree;

import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem501 {

    List<Integer> res = new ArrayList<>();
    TreeNode prev = null;
    int currentCount = 1;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        return res.stream().mapToInt(i->i).toArray();
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);

        if(prev != null){
            if(root.val == prev.val){
                currentCount++;
            }else {
                currentCount = 1;
            }
        }

        if(currentCount > maxCount){
            res.clear();
            res.add(root.val);
            maxCount = currentCount;
        }else if(currentCount == maxCount){
            res.add(root.val);
        }

        prev = root;


        inorder(root.right);

    }
}
