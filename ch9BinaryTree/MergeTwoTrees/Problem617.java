package ch9BinaryTree.MergeTwoTrees;

import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem617 {
    public static void main(String[] args) {
        Problem617 solution = new Problem617();

        // 创建第一个树：[1,3,2,5]
        TreeNode root1 = solution.createTree(new Integer[]{1,3,2,5});

        // 创建第二个树：[2,1,3,null,4,null,7]
        TreeNode root2 = solution.createTree(new Integer[]{2,1,3,null,4,null,7});

        // 合并两个树
        TreeNode mergedRoot = solution.mergeTrees(root1, root2);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        TreeNode root;
        if(root1 == null){
/*            root = new TreeNode(root2.val);
            root.left = root2.left;
            root.right = root2.right;*/
            root = root2;
        }else if(root2 == null){
//            root = new TreeNode(root1.val);
            root = root1;
        }else {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left,root2.left);
            root.right = mergeTrees(root1.right,root2.right);
        }
        return root;
    }
    public TreeNode createTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();
            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

}
