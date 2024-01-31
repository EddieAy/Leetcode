package ch9BinaryTree.BinaryTreePaths;

import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        // 测试 binaryTreePaths 方法
        List<String> result = binaryTreePaths(root);
        System.out.println(result); // 应该输出 ["1->2->5","1->3"]
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        getPaths(root,res,sb);
        return res;
    }

    private static void getPaths(TreeNode root, List<String> res, StringBuilder sb) {
        int currentLength = sb.length();
        if(root!=null){
            sb.append(root.val);
            if(root.left == null && root.right == null){
                res.add(sb.toString());
            }else {
                sb.append("->");
                getPaths(root.left,res,sb);
                getPaths(root.right,res,sb);
            }
            sb.setLength(currentLength);
        }
    }
    private static void getPaths2(TreeNode root, List<String> res, StringBuilder sb) {
        if(root.left == null && root.right == null){
            int currentLength = sb.length();
            sb.append(root.val);
            res.add(sb.toString());
            sb.setLength(currentLength);
        }else if (root.left != null && root.right == null){
            int currentLength = sb.length();
            sb.append(root.val);
            sb.append("->");
            getPaths(root.left,res,sb);
            sb.setLength(currentLength);

        }else if(root.right != null && root.left == null){
            int currentLength = sb.length();
            sb.append(root.val);
            sb.append("->");
            getPaths(root.right,res,sb);
            sb.setLength(currentLength);
        }else {
            int currentLength = sb.length();
            sb.append(root.val);
            sb.append("->");
            getPaths(root.left,res,sb);
            getPaths(root.right,res,sb);
            sb.setLength(currentLength);
        }
    }
}
