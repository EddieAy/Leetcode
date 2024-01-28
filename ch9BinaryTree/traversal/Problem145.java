package ch9BinaryTree.traversal;

import java.util.ArrayList;
import java.util.List;
import ch9BinaryTree.TreeNode;

public class Problem145 {
    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travsersal(root,res);

        return res;
    }

    private static void travsersal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        travsersal(root.left,res);
        travsersal(root.right,res);
        res.add(root.val);
    }


}
