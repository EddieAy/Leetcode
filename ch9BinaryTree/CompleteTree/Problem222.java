package ch9BinaryTree.CompleteTree;

import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem222 {
    public static void main(String[] args) {
        System.out.println(3 << 2); // 0 0 1 1    1 1 0 0   a *  2 ^ b
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            count += len;
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();

                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return count;
    }

    public int countNodes2(TreeNode root){
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == rightDepth){//左子树是满的 2 ^ rd - 1 + 根=1 + zuo
            return (1 << leftDepth) + countNodes2(root.right);
        }else {// 右子树是满的  2 &
            return (1 << rightDepth) + countNodes2(root.left);
        }
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        while (root!=null){
            count+=1;
            root = root.left;
        }
        return count;
    }
}


/*
*       1
*   2       3
* 4   5   6    7
*8 9 10 11 12
*
*
*
* */