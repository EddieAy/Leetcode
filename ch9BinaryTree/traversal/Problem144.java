package ch9BinaryTree.traversal;

import java.util.ArrayList;
import java.util.List;
import ch9BinaryTree.TreeNode;

public class Problem144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    public static void traversal(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        traversal(root.left,res);
        traversal(root.right,res);
    }
}
