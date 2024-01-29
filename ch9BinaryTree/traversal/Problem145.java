package ch9BinaryTree.traversal;

import java.util.*;

import ch9BinaryTree.TreeNode;

class StackNode{
    public boolean visited;
    public TreeNode node;

    public StackNode(boolean visited, TreeNode node) {
        this.visited = visited;
        this.node = node;
    }
}

public class Problem145 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode node6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, node4, node6);


        // 调用函数
        List<Integer> res = postorderTraversal4(root);

        // 输出结果
        System.out.println(res);  // 应当输出 [5, 4, 1, 2, 6]

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

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur!=null || !st.isEmpty()){
            while (cur!=null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (cur.right == null || cur.right == prev){
                res.add(cur.val);
                prev = cur;
                cur = null;
            }else {
                st.push(cur);
                cur = cur.right;
            }
        }

        return res;
    }

    public static List<Integer> postorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        if (root == null) return res;
        st.push(root);
        while (!st.isEmpty()){
            TreeNode temp = st.peek();
            st.pop();
            res.add(temp.val);
            if (temp.left != null) st.push(temp.left);
            if (temp.right != null) st.push(temp.right);
        }
        //根 右 左
        //
        Collections.reverse(res);
        return res;
    }

    public static List<Integer> postorderTraversal4(TreeNode root){


        List<Integer> res = new ArrayList<>();
        Deque<StackNode> st = new LinkedList<>();
        if (root == null) return res;
        st.push(new StackNode(false,root));
        while (!st.isEmpty()){
            StackNode stNode = st.pop();
            if (stNode.node == null) continue;
            if (!stNode.visited){//后序是  左右根      所以入栈 应该为  根右左
                st.push(new StackNode(true,stNode.node));//根
                st.push(new StackNode(false,stNode.node.right));
                st.push(new StackNode(false,stNode.node.left));
            }else {
                res.add(stNode.node.val);
            }
        }
        return res;
    }
}
