package ch9BinaryTree.FindBottomLeftTreeValue;

import ch9BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem513 {
    public static void main(String[] args) {
        // 根据给定数组手动构造二叉树
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = null;

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = null;

        // 测试输出
        System.out.println(findBottomLeftValue2(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp1 = null;
        while (!queue.isEmpty()){
            int len = queue.size();
            boolean flag = true;
            while (len > 0){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    if(flag){
                        temp1 = temp.left;
                        queue.offer(temp.left);
                        flag = false;
                    }else {
                        queue.offer(temp.left);
                    }
                }
                if(temp.right != null){
                    if(flag){
                        temp1 = temp.right;
                        queue.offer(temp.right);
                        flag = false;
                    }else {
                        queue.offer(temp.right);
                    }
                }
                len--;
            }
        }
        return temp1.val;
    }

    public static int findBottomLeftValue2(TreeNode root){
        if (root.left == null && root.right == null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            ans = queue.peek().val;
            while (len > 0){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }

                len--;
            }
        }
        return ans;
    }
    public static int findBottomLeftValue3(TreeNode root){
        if (root.left == null && root.right == null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.right != null){
                queue.offer(temp.right);
            }
            if(temp.left != null){
                queue.offer(temp.left);
            }
            ans = temp.val;
        }
        return ans;
    }

    static int curVal = 0;
    static int curHeight = 0;
    public static int findBottomLeftValue4(TreeNode root){
        dfs(root,0);
        return curVal;
    }

    public static void dfs(TreeNode root,int height){
        if (root == null) return;
        height++;
        dfs(root.left,height);
        dfs(root.right,height);
        if(height > curHeight){
            curHeight = height;
            curVal = root.val;
        }
    }
}
//第一个 左节点不为空的记录下来
//如果下一层还有，替换
//如果这一层 没有左 break 直接返回
